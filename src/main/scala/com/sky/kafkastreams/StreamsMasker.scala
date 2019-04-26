package com.sky.kafkastreams

import java.time.Duration
import java.util
import java.util.{Properties, UUID}

import com.ovoenergy.kafka.serialization.circe.circeJsonDeserializer
import entities.{MaskedPlayVodJsonMessage, PlayVodJsonMessage}
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.streams.kstream.{Consumed, KStream, Produced, ValueMapper}
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig, Topology}
import io.circe.generic.auto._
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.common.serialization._
import com.ovoenergy.kafka.serialization.circe.{circeJsonDeserializer, _}
import com.ovoenergy.kafka.serialization.core.{nullDeserializer, nullSerializer}
import org.apache.kafka.streams.Topology.AutoOffsetReset
import org.apache.kafka.streams.processor.LogAndSkipOnInvalidTimestamp

object StreamsMasker extends App {

  private val playTopic ="play-topic"
  private val maskedTopic = "masked-play-topic"
  implicit val playSerde = Serdes.serdeFrom(circeJsonSerializer[PlayVodJsonMessage],circeJsonDeserializer[PlayVodJsonMessage])
  implicit val nullSerde = Serdes.serdeFrom(nullSerializer[Unit],nullDeserializer[Unit])
  implicit val maskedSerde = Serdes.serdeFrom(circeJsonSerializer[MaskedPlayVodJsonMessage],circeJsonDeserializer[MaskedPlayVodJsonMessage])


  val props: Properties = {
    val p = new Properties()

      p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG , "localhost:9092")
      p.put(StreamsConfig.APPLICATION_ID_CONFIG , s"example+${UUID.randomUUID().toString}")
      p.put(StreamsConfig.CONSUMER_PREFIX + ConsumerConfig.AUTO_OFFSET_RESET_CONFIG , "latest")
      p
  }

  lazy val maskPII: ValueMapper[PlayVodJsonMessage, MaskedPlayVodJsonMessage]=
    (playVodJsonMessage: PlayVodJsonMessage) => MaskedPlayVodJsonMessage(playVodJsonMessage.copy())

  val builder = new StreamsBuilder

  println("building streams")
  builder.stream(playTopic, Consumed.`with`(nullSerde, playSerde))
      .peek((k,v) => {println(s"DEBUG: ${v.contentId}, ${v.contentId}")})
      .mapValues[MaskedPlayVodJsonMessage](maskPII)
      .through(maskedTopic, Produced.`with`(nullSerde,maskedSerde))


  val kafkaStreams = new KafkaStreams(builder.build(),props)
  kafkaStreams.start()

  sys.ShutdownHookThread {
    kafkaStreams.close(Duration.ofSeconds(10))
  }

}

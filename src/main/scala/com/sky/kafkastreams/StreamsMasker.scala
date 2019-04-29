package com.sky.kafkastreams

import java.time.Duration
import java.util.{Properties, UUID}

import com.ovoenergy.kafka.serialization.circe.{circeJsonDeserializer, _}
import com.ovoenergy.kafka.serialization.core.{nullDeserializer, nullSerializer}
import entities.{MaskedPlayMessage, PlayJsonMessage}
import io.circe.generic.auto._
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization._
import org.apache.kafka.streams.kstream.{Consumed, KStream, Produced, ValueMapper}
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig}

object StreamsMasker extends App {

  private val playTopic = "play-topic"
  private val maskedTopic = "masked-play-topic"

  val playSerde = Serdes.serdeFrom(circeJsonSerializer[PlayJsonMessage], circeJsonDeserializer[PlayJsonMessage])
  val nullSerde = Serdes.serdeFrom(nullSerializer[Unit], nullDeserializer[Unit])
  val maskedSerde = Serdes.serdeFrom(circeJsonSerializer[MaskedPlayMessage], circeJsonDeserializer[MaskedPlayMessage])


  val props: Properties = {
    val p = new Properties()

    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    p.put(StreamsConfig.APPLICATION_ID_CONFIG, s"masking+${UUID.randomUUID().toString}")
    p
  }

  lazy val maskPII: ValueMapper[PlayJsonMessage, MaskedPlayMessage] =
    (playVodJsonMessage: PlayJsonMessage) => MaskedPlayMessage(playVodJsonMessage.copy())

  val builder = new StreamsBuilder

  builder.stream(playTopic, Consumed.`with`(nullSerde, playSerde))
    .peek((k, v) => println(s"DEBUG: DeviceId : ${v.deviceId}, houseHoldId : ${v.householdId}"))
    .mapValues[MaskedPlayMessage](maskPII)
    .through(maskedTopic, Produced.`with`(nullSerde, maskedSerde))


  val kafkaStreams = new KafkaStreams(builder.build(), props)
  kafkaStreams.start()

  sys.ShutdownHookThread {
    kafkaStreams.close(Duration.ofSeconds(10))
  }

}

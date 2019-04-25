package com.sky.kafkastreams

import org.scalatest.FlatSpec
import io.circe.{Decoder, Encoder, Json}
import io.circe.generic.auto._
import io.circe.syntax._
import org.apache.kafka.common.serialization.{Deserializer, Serializer, StringDeserializer, StringSerializer}
import com.ovoenergy.kafka.serialization.circe.{circeJsonDeserializer, _}



class CirceTest extends FlatSpec{

//  it should "serialize deserialize play entity json " in {
//
//    val json = PlayEntity(deviceId="259849307543",
//      contentId = "A438985").asJson




//  }





}

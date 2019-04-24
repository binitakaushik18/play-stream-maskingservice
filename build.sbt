name := "kafka-streams-example"

version := "0.1"

scalaVersion := "2.12.6"
private val confluentVersion = "4.0.0"
private val ovoVersion = "0.3.10"
private val circeVersion = "0.9.2"
private val kafkastreams = "2.0.0"

libraryDependencies ++= Seq(

  "javax.ws.rs" % "javax.ws.rs-api" % "2.1.1" artifacts (Artifact("javax.ws.rs-api", "jar", "jar")),
  "org.apache.kafka" % "kafka-streams" % kafkastreams,
  "com.madewithtea" %% "mockedstreams" % "2.1.0" % Test,
  "org.apache.kafka" %% "kafka-streams-scala" % "2.1.0",

  "io.confluent" % "kafka-schema-registry" % confluentVersion,
  "io.confluent" % "kafka-avro-serializer" % confluentVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-java8" % circeVersion,
  "io.confluent" % "kafka-schema-registry" % confluentVersion,
  "io.confluent" % "kafka-avro-serializer" % confluentVersion,
  "com.ovoenergy" %% "kafka-serialization-core" % ovoVersion,
  "com.ovoenergy" %% "kafka-serialization-circe" % ovoVersion,
  "com.ovoenergy" %% "kafka-serialization-avro4s" % ovoVersion,

  "org.scalatest" %% "scalatest" % "3.0.5" % "test"

)
resolvers += Resolver.bintrayRepo("sky-uk", "oss-maven")


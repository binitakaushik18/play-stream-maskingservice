# Play messages Streaming App

This kafka streams application written in Scala reads from Kafka topic `play-topic` and masks the PII (personally identifiable information) before 
writing to a new topic `masked-play-topic`. This was created so that production data can be masked and used for stage or nft environment.
 
Acceptable play-topic looks like:

``` 
{
  "activityTimestamp": "2019-04-26T09:48:11.958Z",
  "activityType": "PLAY_VOD",
  "contentId": "A5EK52ZzND7HTCea1q5Yy",
  "countryCode": "GB",
  "deviceId": "YD0036858092",
  "deviceModel": "3801UK",
  "devicePlatform": "ROKU",
  "deviceType": "SETTOPBOX",
  "geoIP": {
    "countryCode": "gb",
    "ipAddress": "151.229.9.84"
  },
  "homeTerritory": "GB",
  "householdId": "64690706",
  "ipAddress": "151.229.9.84",
  "offerType": "TVBOXSETS",
  "originatingSystem": "VIDEO",
  "personaId": "b00b1cd1-ea63-33bb-b3fc-c69baf3c2ad0",
  "proposition": "NOWTV",
  "provider": "NOWTV",
  "providerTerritory": "GB",
  "providerVariantId": "A5EK52ZzND7HTCea1q5Yy",
  "requestId": "2980ec8c-1c42-44b4-92c1-0267520ad3c7",
  "streamingTicket": "6a74b458-60cd-4da4-a45a-21ffd77e8ae4",
  "userId": "64690706",
  "userType": "NON_DTH"
}
```

Once the stream job is run it will write to `masked-play-topic`.

### How to run
1. Go to docker-compose folder and run `docker-compose up -d` to start kafka and zookeeper
2. Install confluent-kafka from https://www.confluent.io/download/.  
3. Go to ${confluent-bin} to create the topics by
    ``./kafka-topics --create --topic play-topic --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1``
    ``./kafka-topics --create --topic masked-play-topic --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1``
4. Produce json messages to `play-topic` by 
   ``/kafka-console-producer --broker-list localhost:9092 --topic play-topic``
   Sample json message can be found above 
5. Run kafka-console-consumer to consume from masked-play-topic and check messages being produced run time by StreamsMasker   
6. Run StreamsMasker to start the stream
7. Masked householdId and deviceId will be generated on `masked-play-topic` kafka topic

 




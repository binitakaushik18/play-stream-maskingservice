Play streams masking app

This streaming application reads from playTopic and masks the PII (personally identifiable information) and 
writes to a new topic masked-play-topic.
 
play-topic currently has only 
{"deviceId":"wqe3748349", "contentId":"dj348r43r84"}

masked-play-topic will contain

Later move to real play message:
``{"activityTimestamp":"2019-04-05T00:00:16.670Z","activityType":"PLAY_VOD","provider":"SKY","providerTerritory":"GB","homeTerritory":"GB","proposition":"SKYGO","userId":"999444191073","userType":"DTH","householdId":"12867921277303092851789","deviceId":"0050004C005300500053005F004B004500450050005F003300330030003700340032","deviceType":"MOBILE","devicePlatform":"ANDROID","deviceModel":"Nexus 9","countryCode":"GB","contentId":"1dcf95d0a99d2610VgnVCM1000000b43150a____","providerVariantId":"1dcf95d0a99d2610VgnVCM1000000b43150a____","countryOverride":"GB","ipAddress":"213.120.228.1","offerType":"TVBOXSETS","requestId":"523f42bb-f624-4539-b170-22d3b3b9ba8e","streamingTicket":"92806945-f4da-4fb2-9bd2-4ed23ea8d7e4","originatingSystem":"VIDEO"}
  
  {"activityTimestamp":"2019-04-05T00:00:16.839Z","activityType":"PLAY_VOD","provider":"NOWTV","providerTerritory":"GB","homeTerritory":"GB","proposition":"NOWTV","userId":"999632533210","userType":"NON_DTH","householdId":"999632533210","deviceId":"21b7ddebbda366020178ca13a56bcda5efc7bd4f","deviceType":"SETTOPBOX","devicePlatform":"ROKU","deviceModel":"4500SK","countryCode":"GB","contentId":"A5EK6sKrAaycgmj6RVDUd","providerVariantId":"A5EK6sKrAaycgmj6RVDUd","ipAddress":"213.120.228.1","geoIP":{"ipAddress":"213.120.228.1","countryCode":"gb"},"personaId":"bcddbd2c-61d7-3bf9-ab21-71d776dac50a","offerType":"TVBOXSETS","requestId":"e0d3e12c-5144-4649-81b4-b174665e1020","streamingTicket":"e965e3c1-880b-4fb6-9679-d87696e9d99f","originatingSystem":"VIDEO"}
  
  {"activityTimestamp":"2019-04-05T00:00:16.840Z","activityType":"PLAY_VOD","provider":"NOWTV","providerTerritory":"GB","homeTerritory":"GB","proposition":"NOWTV","userId":"999468006371","userType":"NON_DTH","householdId":"999468006371","deviceId":"0ee6195f7130cf2a99450911315e167689e7d554","deviceType":"SETTOPBOX","devicePlatform":"ROKU","deviceModel":"4500SK","countryCode":"GB","contentId":"97f0d378a77bc510VgnVCM1000000b43150a____","providerVariantId":"97f0d378a77bc510VgnVCM1000000b43150a____","ipAddress":"213.120.228.1","geoIP":{"ipAddress":"213.120.228.1","countryCode":"gb"},"personaId":"7d239440-3589-34cb-900d-fa4c79d0aa01","offerType":"TVBOXSETS","requestId":"b6f2ddbf-2ac7-476f-888d-fd279e9ddc4e","streamingTicket":"c6de0040-a399-425a-9cc3-cd59be807e66","originatingSystem":"VIDEO"}``






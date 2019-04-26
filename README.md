Play streams masking app

This streaming application reads from playTopic and masks the PII (personally identifiable information) and 
writes to a new topic masked-play-topic.
 
play-topic currently has only 
{"deviceId":"wqe3748349", "contentId":"dj348r43r84"}

masked-play-topic will contain


TODO to process and mask householdId and deviceId
Later move to real play message:
```
{"activityTimestamp":"2019-04-26T09:48:11.958Z","activityType":"PLAY_VOD","provider":"NOWTV","providerTerritory":"GB","homeTerritory":"GB","proposition":"NOWTV","userId":"64690706","userType":"NON_DTH","householdId":"64690706","deviceId":"YD0036858092","deviceType":"SETTOPBOX","devicePlatform":"ROKU","deviceModel":"3801UK","countryCode":"GB","contentId":"A5EK52ZzND7HTCea1q5Yy","providerVariantId":"A5EK52ZzND7HTCea1q5Yy","ipAddress":"151.229.9.84","geoIP":{"ipAddress":"151.229.9.84","countryCode":"gb"},"personaId":"b00b1cd1-ea63-33bb-b3fc-c69baf3c2ad0","offerType":"TVBOXSETS","requestId":"2980ec8c-1c42-44b4-92c1-0267520ad3c7","streamingTicket":"6a74b458-60cd-4da4-a45a-21ffd77e8ae4","originatingSystem":"VIDEO"}
{"activityTimestamp":"2019-04-26T09:48:11.985Z","activityType":"PLAY_VOD","provider":"NOWTV","providerTerritory":"GB","homeTerritory":"GB","proposition":"NOWTV","userId":"46873539","userType":"NON_DTH","householdId":"46873539","deviceId":"32556M003758","deviceType":"SETTOPBOX","devicePlatform":"ROKU","deviceModel":"4200SK","countryCode":"GB","contentId":"A5EK5SE7uEUjaTgSShND7","providerVariantId":"A5EK5SE7uEUjaTgSShND7","ipAddress":"5.81.222.177","geoIP":{"ipAddress":"5.81.222.177","countryCode":"gb"},"personaId":"b4e8693f-3fb5-34d2-847d-18114ad4b63a","offerType":"TVBOXSETS","requestId":"3833cfe6-6e67-423f-b925-e6342c56707a","streamingTicket":"025e9d50-fdf7-4f32-a187-b97585248aa3","originatingSystem":"VIDEO"}
{"activityTimestamp":"2019-04-26T09:48:11.439Z","activityType":"PLAY_VOD","provider":"NOWTV","providerTerritory":"GB","homeTerritory":"GB","proposition":"NOWTV","userId":"49799261","userType":"NON_DTH","householdId":"49799261","deviceId":"cb101803-679c-95cf-afcc-89c6fbb84b58","deviceType":"CONSOLE","devicePlatform":"XBOX","deviceModel":"XBOX","countryCode":"GB","contentId":"A5EK4hNSMYgNizzeGTjBS","providerVariantId":"A5EK4hNSMYgNizzeGTjBS","ipAddress":"2.124.45.233","geoIP":{"ipAddress":"2.124.45.233","countryCode":"gb"},"personaId":"14482697-67cc-3ff6-894f-6510ab268a62","offerType":"TVBOXSETS","requestId":"67106019-cf9e-4dec-9051-6a11a61374dc","streamingTicket":"e087396f-2db1-48f1-9c4c-ea1df3f4b245","originatingSystem":"VIDEO"}






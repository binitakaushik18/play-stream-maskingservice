import java.time.OffsetDateTime
import java.util.UUID

import io.circe.Json

package object entities {



  case class MaskedPlayVodJsonMessage(timestamp: String,
                              streamingTicket: String,
                              contentId: String,
                              deviceId: String,
                              proposition: String,
                              provider: String,
                              providerTerritory: String,
                              householdId: String,
                              personaId: Option[String] = None)


  case class PlayVodJsonMessage(timestamp: String,
                                streamingTicket: String,
                                contentId: String,
                                deviceId: String,
                                proposition: String,
                                provider: String,
                                providerTerritory: String,
                                householdId: String,
                                personaId: Option[String] = None)
  //{
//    def toJson: String =
//      Json
//        .obj(
//          "activityTimestamp" -> timestamp.asJson,
//          "streamingTicket"   -> streamingTicket.asJson,
//          "contentId"         -> contentId.asJson,
//          "deviceId"          -> deviceId.asJson,
//          "ipAddress"         -> "10.91.7.01".asJson,
//          "proposition"       -> proposition.asStringValue.asJson,
//          "provider"          -> provider.asStringValue.asJson,
//          "providerTerritory" -> providerTerritory.asStringValue.asJson,
//          "householdId"       -> householdId.asJson,
//          "personaId"         -> personaId.fold(Json.Null)(_.toString.asJson)
//        )
//        .noSpaces
//  }




  object MaskedPlayVodJsonMessage
  {
    def apply(playMessage: PlayVodJsonMessage): MaskedPlayVodJsonMessage = {

       MaskedPlayVodJsonMessage(
        timestamp = playMessage.timestamp,
        streamingTicket = playMessage.streamingTicket,
        deviceId = playMessage.deviceId.hashCode.toString,
        contentId = playMessage.contentId,
        proposition = playMessage.proposition,
        provider = playMessage.provider,
        providerTerritory = playMessage.providerTerritory,
        householdId = playMessage.householdId.hashCode.toString,
        personaId = playMessage.personaId)


    }
  }
}

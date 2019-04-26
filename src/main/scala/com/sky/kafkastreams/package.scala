import java.time.OffsetDateTime
import java.util.{Base64, UUID}

import io.circe.Json
import io.netty.handler.codec.string.StringEncoder
import io.netty.util.CharsetUtil

package object entities {



  case class MaskedPlayVodJsonMessage(activityTimestamp: String,
                              streamingTicket: String,
                              contentId: String,
                              deviceId: String,
                              proposition: String,
                              provider: String,
                              providerTerritory: String,
                              householdId: String,
                              personaId: Option[String] = None)


  case class PlayVodJsonMessage(activityTimestamp : String,
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
        activityTimestamp = playMessage.activityTimestamp,
        streamingTicket = playMessage.streamingTicket,
        deviceId = Base64.getEncoder.encodeToString(playMessage.deviceId.getBytes(CharsetUtil.UTF_8)),
        contentId = playMessage.contentId,
        proposition = playMessage.proposition,
        provider = playMessage.provider,
        providerTerritory = playMessage.providerTerritory,
        householdId = Base64.getEncoder.encodeToString(playMessage.householdId.getBytes(CharsetUtil.UTF_8)),
        personaId = playMessage.personaId)


    }
  }
}

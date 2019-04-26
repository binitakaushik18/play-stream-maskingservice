import java.time.OffsetDateTime
import java.util.{Base64, UUID}

import io.circe.Json
import io.netty.handler.codec.string.StringEncoder
import io.netty.util.CharsetUtil

package object entities {

  case class MaskedPlayMessage(activityTimestamp: String,
                               streamingTicket: String,
                               contentId: String,
                               deviceId: String,
                               proposition: String,
                               provider: String,
                               providerTerritory: String,
                               householdId: String,
                               personaId: Option[String] = None)

  case class PlayJsonMessage(activityTimestamp : String,
                             streamingTicket: String,
                             contentId: String,
                             deviceId: String,
                             proposition: String,
                             provider: String,
                             providerTerritory: String,
                             householdId: String,
                             personaId: Option[String] = None)


  object MaskedPlayMessage
  {
    def apply(playMessage: PlayJsonMessage): MaskedPlayMessage = {

       MaskedPlayMessage(
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

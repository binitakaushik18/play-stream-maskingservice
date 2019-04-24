import java.time.OffsetDateTime

package object entities {

  case class PlayEntity(deviceId: String, contentId: String)
  case class MaskedPlayEntity(maskedDeviceId: String, contentId: String)



  object MaskedPlayEntity{
    def apply(playEntity: PlayEntity): MaskedPlayEntity = {

      MaskedPlayEntity(maskedDeviceId = playEntity.deviceId.hashCode.toString,
        contentId = playEntity.contentId)
    }
  }
}

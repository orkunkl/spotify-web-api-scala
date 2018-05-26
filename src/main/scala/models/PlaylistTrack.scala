package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class PlaylistTrack(
    added_at: java.util.Date,
    added_by: Option[PublicUser],
    is_local: Boolean,
    track: Track
)

object PlaylistTrack {
  implicit val playlistTrackReads: Reads[PlaylistTrack] = (
    (JsPath \ "added_at").read[java.util.Date] and
      (JsPath \ "added_by").readNullable[PublicUser] and
      (JsPath \ "is_local").read[Boolean] and
      (JsPath \ "track").read[Track]
    )(PlaylistTrack.apply _)
}



package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class SavedTrack(
    added_at: java.util.Date,
    track: Track
)

object SavedTrack {
  implicit val savedTrackReads: Reads[SavedTrack] = (
    (__ \ "added_at").read[java.util.Date] and
      (__ \ "track").read[Track]
    )(SavedTrack.apply _)
}



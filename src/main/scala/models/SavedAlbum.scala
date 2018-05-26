package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class SavedAlbum(
    added_at: java.util.Date,
    album: Album
)

object SavedAlbum {
  implicit val savedAlbumReads: Reads[SavedAlbum] = (
    (__ \ "added_at").read[java.util.Date] and
      (__ \ "album").read[Album]
    )(SavedAlbum.apply _)
}



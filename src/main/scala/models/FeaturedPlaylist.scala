package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class FeaturedPlaylist(
    message: String,
    playlists: Page[PlaylistSimple]
)

object FeaturedPlaylist {
  implicit val featuredPlaylistReads: Reads[FeaturedPlaylist] = (
    (JsPath \ "message").read[String] and
      (JsPath \ "playlists").read[Page[PlaylistSimple]]
    )(FeaturedPlaylist.apply _)
}


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
    (__ \ "message").read[String] and
      (__ \ "playlists").read[Page[PlaylistSimple]]
    )(FeaturedPlaylist.apply _)
}


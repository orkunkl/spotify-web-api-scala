package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Playlist(
    collaborative: Boolean,
    description: String,
    external_urls: Map[String, String],
    followers: Followers,
    href: String,
    id: String,
    images: Seq[Image],
    name: String,
    owner: PublicUser,
    public: Option[Boolean],
    snapshot_id: String,
    tracks: Page[PlaylistTrack],
    `type`: String,
    uri: String
)

object Playlist {
  implicit val playListReads: Reads[Playlist] = (
    (__ \ "collaborative").read[Boolean] and
      (__ \ "description").read[String] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "followers").read[Followers] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "images").read[Seq[Image]] and
      (__ \ "name").read[String] and
      (__ \ "owner").read[PublicUser] and
      (__ \ "public").readNullable[Boolean] and
      (__ \ "snapshot_id").read[String] and
      (__ \ "tracks").read[Page[PlaylistTrack]] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(Playlist.apply _)
}
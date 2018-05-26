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
    (JsPath \ "collaborative").read[Boolean] and
      (JsPath \ "description").read[String] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "followers").read[Followers] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "images").read[Seq[Image]] and
      (JsPath \ "name").read[String] and
      (JsPath \ "owner").read[PublicUser] and
      (JsPath \ "public").readNullable[Boolean] and
      (JsPath \ "snapshot_id").read[String] and
      (JsPath \ "tracks").read[Page[PlaylistTrack]] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(Playlist.apply _)
}
package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class PlaylistSimple(
    collaborative: Boolean,
    external_urls: Map[String, String],
    href: String,
    id: String,
    images: Seq[Image],
    name: String,
    owner: PublicUser,
    public: Option[Boolean],
    snapshot_id: String,
    tracks: Map[String, String],
    `type`: String,
    uri: String
)

object PlaylistSimple {
  implicit val PlaylistSimpleReads: Reads[PlaylistSimple] = (
    (__ \ "collaborative").read[Boolean] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "images").read[Seq[Image]] and
      (__ \ "name").read[String] and
      (__ \ "owner").read[PublicUser] and
      (__ \ "public").readNullable[Boolean] and
      (__ \ "snapshot_id").read[String] and
      (__ \ "tracks").read[Map[String, String]] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(PlaylistSimple.apply _)
}



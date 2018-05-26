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
    (JsPath \ "collaborative").read[Boolean] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "images").read[Seq[Image]] and
      (JsPath \ "name").read[String] and
      (JsPath \ "owner").read[PublicUser] and
      (JsPath \ "public").readNullable[Boolean] and
      (JsPath \ "snapshot_id").read[String] and
      (JsPath \ "tracks").read[Map[String, String]] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(PlaylistSimple.apply _)
}



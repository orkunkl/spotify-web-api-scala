package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class AlbumSimple(
    album_type: String,
    available_markets: Seq[String],
    external_urls: Map[String, String],
    href: String,
    id: String,
    images: Seq[Image],
    name: String,
    `type`: String,
    uri: String
)

object AlbumSimple {
  implicit val albumSimpleReads: Reads[AlbumSimple] = (
    (__ \ "album_type").read[String] and
      (__ \ "available_markets").read[Seq[String]] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "images").read[Seq[Image]] and
      (__ \ "name").read[String] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(AlbumSimple.apply _)
}


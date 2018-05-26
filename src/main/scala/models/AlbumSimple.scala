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
    (JsPath \ "album_type").read[String] and
      (JsPath \ "available_markets").read[String] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "images").read[Seq[Image]] and
      (JsPath \ "name").read[String] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(AlbumSimple.apply _)
}


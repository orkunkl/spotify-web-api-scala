package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class ArtistSimple(
    external_urls: Map[String, String],
    href: String,
    id: String,
    name: String,
    `type`: String,
    uri: String
)


object ArtistSimple {
  implicit val artistSimpleReads: Reads[ArtistSimple] =
    ((JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(ArtistSimple.apply _)
}


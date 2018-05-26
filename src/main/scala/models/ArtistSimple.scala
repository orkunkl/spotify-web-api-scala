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
    ((__ \ "external_urls").read[Map[String, String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "name").read[String] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(ArtistSimple.apply _)
}


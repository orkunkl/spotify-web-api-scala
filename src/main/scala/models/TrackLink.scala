package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class TrackLink(
    external_urls: Map[String, String],
    href: String,
    id: String,
    `type`: String,
    uri: String
)

object TrackLink {
  implicit val trackLinkReads: Reads[TrackLink] = (
    (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[Seq[String]] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(TrackLink.apply _)
}



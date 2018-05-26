package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class  TrackLink(
    external_urls: Map[String, String],
    href: String,
    id: String,
    `type`: String,
    uri: String
)

object TrackLink {
  implicit val trackLinkReads: Reads[TrackLink] = (
    (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(TrackLink.apply _)
}



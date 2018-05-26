package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class PublicUser(
    display_name: Option[String],
    external_urls: Map[String, String],
    followers: Option[Followers],
    href: String,
    id: String,
    images: Option[Seq[Image]],
    `type`: String,
    uri: String
)

object PublicUser {
  implicit val publicUserReads: Reads[PublicUser] = (
    (__ \ "display_name").readNullable[String] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "followers").readNullable[Followers] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "images").readNullable[Seq[Image]] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(PublicUser.apply _)
}

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
    (JsPath \ "display_name").readNullable[String] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "followers").readNullable[Followers] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "images").readNullable[Seq[Image]] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(PublicUser.apply _)
}

package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class PrivateUser(
    birthdate: Option[String],
    country: Option[String],
    display_name: Option[String],
    email: Option[String],
    external_urls: Map[String, String],
    followers: Followers,
    href: String,
    id: String,
    images: Seq[Image],
    product: Option[String],
    `type`: String,
    uri: String
)

object PrivateUser {
  implicit val privateUserReads: Reads[PrivateUser] = (
    (JsPath \ "birthdate").readNullable[String] and
      (JsPath \ "country").readNullable[Followers] and
      (JsPath \ "display_name").readNullable[String] and
      (JsPath \ "email").readNullable[String] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "followers").read[Followers] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[Int] and
      (JsPath \ "images").read[Seq[Image]] and
      (JsPath \ "product").readNullable[String] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(PrivateUser.apply _)
}

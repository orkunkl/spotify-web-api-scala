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
    (__ \ "birthdate").readNullable[String] and
      (__ \ "country").readNullable[Followers] and
      (__ \ "display_name").readNullable[String] and
      (__ \ "email").readNullable[String] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "followers").read[Followers] and
      (__ \ "href").read[String] and
      (__ \ "id").read[Int] and
      (__ \ "images").read[Seq[Image]] and
      (__ \ "product").readNullable[String] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(PrivateUser.apply _)
}

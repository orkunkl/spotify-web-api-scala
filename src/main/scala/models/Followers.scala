package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Followers(
    href: Option[String],
    total: Int
)

object Followers {
  implicit val followersReads: Reads[Followers] = (
    (JsPath \ "href").readNullable[String] and
      (JsPath \ "total").read[Int]
    )(Followers.apply _)
}


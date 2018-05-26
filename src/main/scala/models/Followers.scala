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
    (__ \ "href").readNullable[String] and
      (__ \ "total").read[Int]
    )(Followers.apply _)
}


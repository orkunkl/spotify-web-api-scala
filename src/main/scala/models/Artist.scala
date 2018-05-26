package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Artist(
    external_urls: Map[String, String],
    followers: Followers,
    genres: Seq[String],
    href: String,
    id: String,
    images: Seq[Image],
    name: String,
    popularity: Int,
    `type`: String,
    uri: String
)

object Artist {
  implicit val artistReads: Reads[Artist] = (
    (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "followers").read[Followers] and
      (__ \ "genres").read[Seq[String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "images").read[Seq[Image]] and
      (__ \ "name").read[String] and
      (__ \ "popularity").read[Int] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(Artist.apply _)
}



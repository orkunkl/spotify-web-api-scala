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
    (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "followers").read[Followers] and
      (JsPath \ "genres").read[Seq[String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "images").read[Seq[Image]] and
      (JsPath \ "name").read[String] and
      (JsPath \ "popularity").read[Int] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(Artist.apply _)
}



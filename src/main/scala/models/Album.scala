package models
import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Album(
    album_type: String,
    artists: Seq[ArtistSimple],
    available_markets: Seq[String],
    copyrights: Seq[Copyright],
    external_ids: Map[String, String],
    external_urls: Map[String, String],
    genres: Seq[String],
    href: String,
    id: String,
    images: Seq[Image],
    name: String,
    popularity: Int,
    release_date: String,
    release_date_precision: String,
    tracks: Page[TrackSimple],
    `type`: String,
    uri: String)

object Album {
  implicit val albumReads: Reads[Album] = (
    (JsPath \ "album_type").read[String] and 
      (JsPath \ "artists").read[Seq[Artist]] and
      (JsPath \ "available_markets").read[String] and
      (JsPath \ "copyrights").read[Seq[Copyright]] and
      (JsPath \ "external_ids").read[Map[String, String]] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "genres").read[Seq[String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "images").read[Seq[Image]] and
      (JsPath \ "name").read[String] and
      (JsPath \ "popularity").read[Int] and
      (JsPath \ "release_date").read[String] and
      (JsPath \ "release_date_precision").read[String] and
      (JsPath \ "tracks").read[Page[TrackSimple]] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(Album.apply _)
}


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
    (__ \ "album_type").read[String] and
      (__ \ "artists").read[Seq[ArtistSimple]] and
      (__ \ "available_markets").read[String] and
      (__ \ "copyrights").read[Seq[Copyright]] and
      (__ \ "external_ids").read[Map[String, String]] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "genres").read[Seq[String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "images").read[Seq[Image]] and
      (__ \ "name").read[String] and
      (__ \ "popularity").read[Int] and
      (__ \ "release_date").read[String] and
      (__ \ "release_date_precision").read[String] and
      (__ \ "tracks").read[Page[TrackSimple]] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(Album.apply _)
}


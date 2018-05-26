package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Track(
    album: AlbumSimple,
    artists: Seq[ArtistSimple],
    available_markets: Seq[String],
    disc_number: Int,
    duration_ms: Int,
    explicit: Boolean,
    external_ids: Map[String, String],
    external_urls: Map[String, String],
    href: String,
    id: String,
    is_playable: Option[Boolean],
    linked_from: Option[TrackLink],
    name: String,
    popularity: Int,
    preview_url: String,
    track_number: Int,
    `type`: String,
    uri: String
)

object Track {
  implicit val trackReads: Reads[Track] = (
    (JsPath \ "album").read[Album] and
      (JsPath \ "artists").read[Seq[ArtistSimple]] and
      (JsPath \ "available_markets").read[Seq[String]] and
      (JsPath \ "disc_number").read[Int] and
      (JsPath \ "duration_ms").read[Int] and
      (JsPath \ "explicit").read[Boolean] and
      (JsPath \ "external_ids").read[Map[String, String]] and
      (JsPath \ "external_urls").read[Map[String, String]] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "is_playable").readNullable[Boolean] and
      (JsPath \ "linked_from").readNullable[TrackLink] and
      (JsPath \ "name").read[String] and
      (JsPath \ "popularity").read[Int] and
      (JsPath \ "preview_url").read[String] and
      (JsPath \ "track_number").read[Int] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String]
    )(Track.apply _)
}




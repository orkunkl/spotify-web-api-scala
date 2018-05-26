package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class TrackSimple(
    artists: Seq[ArtistSimple],
    available_markets: Seq[String],
    disc_number: Int,
    duration_ms: Int,
    explicit: Boolean,
    external_urls: Map[String, String],
    href: String,
    id: String,
    is_playable: Option[Boolean],
    linked_from: Option[TrackLink],
    name: String,
    preview_url: String,
    track_number: Int,
    `type`: String,
    uri: String
)

object TrackSimple {
  implicit val trackSimpleReads: Reads[TrackSimple] = (
    (__ \ "artists").read[Seq[ArtistSimple]] and
      (__ \ "available_markets").read[Seq[String]] and
      (__ \ "disc_number").read[Int] and
      (__ \ "duration_ms").read[Int] and
      (__ \ "explicit").read[Boolean] and
      (__ \ "external_urls").read[Map[String, String]] and
      (__ \ "href").read[String] and
      (__ \ "id").read[Int] and
      (__ \ "is_playable").readNullable[Boolean] and
      (__ \ "linked_from").readNullable[TrackLink] and
      (__ \ "name").read[String] and
      (__ \ "preview_url").read[String] and
      (__ \ "track_number").read[Int] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String]
    )(TrackSimple.apply _)
}



package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class AudioFeatures(
    acousticness: Float,
    analysis_url: String,
    danceability: Float,
    duration_ms: Int,
    energy: Float,
    id: String,
    instrumentalness: Float,
    key: Int,
    liveness: Float,
    loudness: Float,
    mode: Int,
    speechiness: Float,
    tempo: Float,
    time_signature: Float,
    track_href: String,
    `type`: String,
    uri: String,
    valence: Float
)

object AudioFeatures {
  implicit val audioFeaturesReads: Reads[AudioFeatures] = (
    (__ \ "acousticness").read[Float] and
      (__ \ "analysis_url").read[String] and
      (__ \ "danceability").read[Float] and
      (__ \ "duration_ms").read[Int] and
      (__ \ "energy").read[Float] and
      (__ \ "id").read[String] and
      (__ \ "instrumentalness").read[Float] and
      (__ \ "key").read[String] and
      (__ \ "liveness").read[Float] and
      (__ \ "key").read[Int] and
      (__ \ "liveness").read[Float] and
      (__ \ "loudness").read[Float] and
      (__ \ "mode").read[Int] and
      (__ \ "speechiness").read[Float] and
      (__ \ "tempo").read[Float] and
      (__ \ "time_signature").read[Float] and
      (__ \ "track_href").read[String] and
      (__ \ "type").read[String] and
      (__ \ "uri").read[String] and
      (__ \ "valence").read[Float]
    )(AudioFeatures.apply _)
}


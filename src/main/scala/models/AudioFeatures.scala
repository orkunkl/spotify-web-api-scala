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
    (JsPath \ "acousticness").read[Float] and
      (JsPath \ "analysis_url").read[String] and
      (JsPath \ "danceability").read[Float] and
      (JsPath \ "duration_ms").read[Int] and
      (JsPath \ "energy").read[Float] and
      (JsPath \ "id").read[String] and
      (JsPath \ "instrumentalness").read[Float] and
      (JsPath \ "key").read[String] and
      (JsPath \ "liveness").read[Float] and
      (JsPath \ "key").read[Int] and
      (JsPath \ "liveness").read[Float] and
      (JsPath \ "loudness").read[Float] and
      (JsPath \ "mode").read[Int] and
      (JsPath \ "speechiness").read[Float] and
      (JsPath \ "tempo").read[Float] and
      (JsPath \ "time_signature").read[Float] and
      (JsPath \ "track_href").read[String] and
      (JsPath \ "type").read[String] and
      (JsPath \ "uri").read[String] and
      (JsPath \ "valence").read[Float]
    )(AudioFeatures.apply _)
}


package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Recommendations(
    seeds: Seq[RecommendationSeed],
    tracks: Seq[TrackSimple]
)

object Recommendations {
  implicit val recommendationReads: Reads[Recommendations] = (
    (JsPath \ "seeds").read[Seq[RecommendationSeed]] and
      (JsPath \ "tracks").read[Seq[TrackSimple]]
    )(Recommendations.apply _)
}



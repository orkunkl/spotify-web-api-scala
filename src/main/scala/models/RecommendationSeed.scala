package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class RecommendationSeed(
    afterFilteringSize: Int,
    afterRelinkingSize: Int,
    href: String,
    id: String,
    initialPoolSize: Int,
    `type`: String
)

object RecommendationSeed {
  implicit val recommendationSeedReads: Reads[RecommendationSeed] = (
    (JsPath \ "afterFilteringSize").read[Int] and
      (JsPath \ "afterRelinkingSize").read[Int] and
      (JsPath \ "href").read[String] and
      (JsPath \ "id").read[String] and
      (JsPath \ "initialPoolSize").read[Int] and
      (JsPath \ "type").read[String]
    )(RecommendationSeed.apply _)
}


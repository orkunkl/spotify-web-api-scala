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
    (__ \ "afterFilteringSize").read[Int] and
      (__ \ "afterRelinkingSize").read[Int] and
      (__ \ "href").read[String] and
      (__ \ "id").read[String] and
      (__ \ "initialPoolSize").read[Int] and
      (__ \ "type").read[String]
    )(RecommendationSeed.apply _)
}


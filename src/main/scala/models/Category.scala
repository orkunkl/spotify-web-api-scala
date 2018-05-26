package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Category(
    href: String,
    icons: Seq[Image],
    id: String,
    name: String
)

object Category {
  implicit val categoryReads: Reads[Category] = (
    (__ \ "href").read[String] and
      (__ \ "icons").read[Seq[Image]] and
      (__ \ "id").read[String] and
      (__ \ "name").read[String]
    )(Category.apply _)
}


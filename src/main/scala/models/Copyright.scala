package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Copyright(text: String, `type`: String)

object Copyright {
  implicit val copyrightReads: Reads[Copyright] = (
    (__ \ "text").read[String] and
      (__ \ "type").read[String]
    )(Copyright.apply _)
}


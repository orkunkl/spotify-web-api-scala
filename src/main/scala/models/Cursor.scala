package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Cursor(
    after: String
)

object Cursor {
  implicit val cursorReads: Reads[Cursor] =
    (JsPath \ "after").read[String](Cursor.apply _)
}


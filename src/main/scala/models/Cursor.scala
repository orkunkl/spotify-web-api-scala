package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._

case class Cursor(
    after: String
)

object Cursor {
  implicit def cursorReads: Reads[Cursor] = {
    case jsval: JsValue =>
      (jsval \ "href").validate[String].map(x => JsSuccess(Cursor(x))).getOrElse(JsError())
    case _ => JsError()
  }
}


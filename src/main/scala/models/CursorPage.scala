package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class CursorPage[T](
    href: String,
    items: Seq[T],
    limit: Int,
    next: Option[String],
    cursors: Cursor,
    total: Int
)

object CursorPage {
  implicit val cursorPageReads: Reads[CursorPage[_]] = (
    (JsPath \ "href").read[String] and
      (JsPath \ "items").read[Seq[_]] and
      (JsPath \ "limit").read[Int] and
      (JsPath \ "next").readNullable[String] and
      (JsPath \ "cursors").read[Cursor] and
      (JsPath \ "total").read[Int]
    )(CursorPage.apply _)
}


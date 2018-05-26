package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._

case class CursorPage[T](
    href: String,
    items: Seq[T],
    limit: Int,
    next: Option[String],
    cursors: Cursor,
    total: Int
)

object CursorPage {

  implicit def cursorPageReades[T](implicit underlying: Reads[T]): Reads[CursorPage[T]] =
    Reads[CursorPage[T]] { json =>
      for {
        href <- (json \ "href").validate[String]
        items <- (json \ "items").validate[Seq[T]]
        limit <- (json \ "limit").validate[Int]
        next <- (json \ "next").validateOpt[String]
        cursors <- (json \ "cursors").validate[Cursor]
        total <- (json \ "total").validate[Int]
      } yield CursorPage(href, items, limit, next, cursors, total)
    }
}


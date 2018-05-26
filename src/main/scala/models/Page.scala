package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._

case class Page[T](
    href: String,
    items: Seq[T],
    limit: Int,
    next: Option[String],
    offset: Int,
    previous: Option[String],
    total: Int
)

object Page {
  implicit def pageReades[T](implicit underlying: Reads[T]): Reads[Page[T]] =
    Reads[Page[T]] { json =>
      for {
        href <- (json \ "href").validate[String]
        items <- (json \ "items").validate[Seq[T]]
        limit <- (json \ "limit").validate[Int]
        next <- (json \ "next").validateOpt[String]
        offset <- (json \ "offset").validate[Int]
        previous <- (json \ "previous").validateOpt[String]
        total <- (json \ "total").validate[Int]
      } yield {
        Page(href, items, limit, next, offset, previous, total)
      }
    }
}

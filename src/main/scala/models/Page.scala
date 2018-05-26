package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

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
  implicit def pageReads[T]: Reads[Page[T]] = new Reads[Page[T]] {
    override def reads(json: JsValue): JsResult[Page[T]] = json match {
      case jsval: JsValue =>
        for {
          href <- (jsval \ "href").validate[String]
          items <- (jsval \ "items").validate[Seq[T]]
          limit <- (jsval \ "limit").validate[Int]
          next <- (jsval \ "next").validateOpt[String]
          offset <- (jsval \ "offset").validate[Int]
          previous <- (jsval \ "previous").validateOpt[String]
          total <- (jsval \ "total").validate[Int]
        } yield {
          JsSuccess(Page(href, items, limit, next, offset, previous, total))
        }.getOrElse(JsError(Seq(JsPath() -> Seq(JsonValidationError("error.custom.bad_user_data")))))
      case _ => JsError()
      }
  }


}

override def reads(json: JsValue): JsResult[Page[T]] = {
  (JsPath \ "href").read[String] and
  (JsPath \ "items").read[Seq[_]] and
  (JsPath \ "limit").read[Int] and
  (JsPath \ "next").read[Option[String]] and
  (JsPath \ "offset").read[Int] and
  (JsPath \ "previous").read[Option[String]] and
  (JsPath \ "total").read[Int]
  Page.apply _
}
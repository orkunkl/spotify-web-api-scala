package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class Image(height: Option[Int], url: String, width: Option[Int])

object Image {
  implicit val imageReads: Reads[Image] = (
    (JsPath \ "height").readNullable[Int] and
      (JsPath \ "url").read[String] and
      (JsPath \ "width").readNullable[Int]
    )(Image.apply _)
}


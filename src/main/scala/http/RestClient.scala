package http
import com.softwaremill.sttp._
import com.softwaremill.sttp.okhttp.OkHttpFutureBackend

class RestClient {
  implicit val backend = OkHttpFutureBackend

  protected def request[T](endpoint: Uri, payload: Map[String, T]) = {
    val request = sttp
      // send the body as form data (x-www-form-urlencoded)
      .body(Map("name" -> "John", "surname" -> "doe"))
      // use an optional parameter in the URI
      .post(endpoint)

    request.send()
  }
}

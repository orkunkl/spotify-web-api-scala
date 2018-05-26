package endpoints

import com.softwaremill.sttp._

class SpotifyEndpoint() extends BaseEndpoint {

  protected val baseAPIUrl = conf.endpoints.baseApiUrl

  //protected def createRequest(endpoint: String): HttpRequest = Http(endpoint)
  protected def createRequest(endpoint: String): HttpRequest = Http(endpoint)

  protected def createRequest(endpoint: String,
                              params: Seq[(String, String)]): HttpRequest = {
    Http(endpoint).params(params)
  }
}

object Spotify

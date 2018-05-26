package endpoints

import scalaj.http.HttpRequest

object SearchEndpoint extends SpotifyEndpoint {

  private val searchEndpoint = conf.endpoints.searchEndpoint

  def search(query: String, queryType: Seq[String]): HttpRequest = {
    val params = Seq(
      ("q", query),
      ("type", queryType.mkString(","))
    )
    createRequest(endpoint = searchEndpoint, params = params)
  }
}

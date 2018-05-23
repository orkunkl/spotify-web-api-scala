package config

import com.typesafe.config.ConfigFactory
import configs.syntax._

object Config {
  private val conf = ConfigFactory.load()
  private val endpointsOpt = for {
    baseApiUrl              <- conf.get[String]("spotify.endpoints.baseApiUrlWithVers").toOption
    albumEndpoint           <- conf.get[String]("spotify.endpoints.albumEndpoint").toOption
    artistEndpoint          <- conf.get[String]("spotify.endpoints.artistEndpoint").toOption
    audioFeaturesEndpoint   <- conf.get[String]("spotify.endpoints.audioFeaturesEndpoint").toOption
    browseEndpoint          <- conf.get[String]("spotify.endpoints.browseEndpoint").toOption
    meEndpoint              <- conf.get[String]("spotify.endpoints.meEndpoint").toOption
    recommendationsEndpoint <- conf.get[String]("spotify.endpoints.recommendationsEndpoint").toOption
    searchEndpoint          <- conf.get[String]("spotify.endpoints.searchEndpoint").toOption
    tracksEndpoint          <- conf.get[String]("spotify.endpoints.tracksEndpoint").toOption
    usersEndpoint           <- conf.get[String]("spotify.endpoints.usersEndpoint").toOption
  } yield {
    Endpoints(
      baseApiUrl,
      albumEndpoint,
      artistEndpoint,
      audioFeaturesEndpoint,
      browseEndpoint,
      meEndpoint,
      recommendationsEndpoint,
      searchEndpoint,
      tracksEndpoint,
      usersEndpoint
    )
  }
  val endpoints = endpointsOpt.getOrElse(throw new Exception)
}

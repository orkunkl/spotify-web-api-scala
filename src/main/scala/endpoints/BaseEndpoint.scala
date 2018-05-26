package endpoints

import config.Config

trait BaseEndpoint {
  val conf = Config
}

package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object loadPageContent {
  def storeDefault(): ChainBuilder = {
    exec(
      http("storeDefault")
        .get(shopizerApi + "store/DEFAULT")
        .check(jsonPath("$.name").is("Default store"))
    )
  }

  def ping(): ChainBuilder = {
    exec(
      http("ping")
        .get(shopizerUrl + "actuator/health/ping")
        .check(jsonPath("$.status").is("UP"))
    )
  }

  def contentPages(): ChainBuilder = {
    exec(
      http("contentPages")
        .get(shopizerApi + "content/pages/?page=0&count=20&store=DEFAULT&lang=en")
    )
  }

  def category(): ChainBuilder = {
    exec(
      http("category")
        .get(shopizerApi + "category/?count=20&page=0&store=DEFAULT&lang=en")
    )
  }
}

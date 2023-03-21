package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object cart {

  def cartStore(): ChainBuilder = {
    exec(
      http("cartStore")
        .get(shopizerApi + "cart/" + orderId + "?store=DEFAULT")
    )
  }

  def cartTotal(): ChainBuilder = {
    exec(
      http("cartTotal")
        .get(shopizerApi + "cart/" + orderId + "/total/")
    )
  }

  def config(): ChainBuilder = {
    exec(
      http("config")
        .get(shopizerApi + "config/")
    )
  }

  def shipping(): ChainBuilder = {
    exec(
      http("shipping")
        .get(shopizerApi + "shipping/country?store=DEFAULT&lang=en")
    )
  }

  def zones(): ChainBuilder = {
    exec(
      http("zones")
        .get(shopizerApi + "zones/?code=")
    )
  }
}

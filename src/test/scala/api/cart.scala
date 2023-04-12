package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object cart {



  def cartStore(): ChainBuilder = {

    exec(
      http("cartStore")
        .get(session => shopizerApi + s"cart/${session("orderId").as[String]}?store=DEFAULT")
        .check(jsonPath("$.code").is(session => s"${session("orderId").as[String]}"))
    )
  }

  def cartTotal(): ChainBuilder = {
    exec(
      http("cartTotal")
        .get(session => shopizerApi + s"cart/${session("orderId").as[String]}/total/")
        .check(jsonPath("$.total").is("$199.00"))
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

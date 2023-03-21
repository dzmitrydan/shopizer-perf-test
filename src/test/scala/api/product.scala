package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._


object product {

  def productReviews(prod: String): ChainBuilder = {
    exec(
      http(s"productReviews#$prod")
        .get(shopizerApi + s"products/$prod/reviews?store=DEFAULT")
    )
  }

  def productInfo(prod: String): ChainBuilder = {
    exec(
      http(s"productInfo#$prod")
        .get(shopizerApi + s"products/$prod?lang=en&store=DEFAULT")
    )
  }
}

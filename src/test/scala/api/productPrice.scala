package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object productPrice {
  def productPrice(prod: String = "1"): ChainBuilder = {
    exec(
      http(s"productPrice#$prod")
        .post(shopizerApi + s"product/$prod/price/")
        .body(StringBody("""{"options":[]}""")).asJson
        .check(jsonPath("$.discounted").is("false"))
    )
  }
}

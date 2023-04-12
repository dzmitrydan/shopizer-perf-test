package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object addProductToCart {


  def addTableToCart(): ChainBuilder = {
    exec(
      http("addTableToCart")
        .post(shopizerApi + "cart/?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"table1","quantity":1}""")).asJson
        .check(regex(""""code":"(.+?)","subtotal"""").saveAs("orderId"))
        .check(jsonPath("$.products[0].refSku").is("table1"))
    )
  }

  def getInfoAboutOrder(prod: String): ChainBuilder = {
    exec(
      http(s"getInfoAbout$prod")
        .get(session => shopizerApi + s"cart/${session("orderId").as[String]}?lang=en")
    )
  }

  def getInfoAboutOrderDefault(): ChainBuilder = {
    exec(
      http("getInfoAboutOrderDefault")
        .get(session => shopizerApi + s"cart/${session("orderId").as[String]}?store=DEFAULT")
    )
  }

  def addChairToCart(): ChainBuilder = {
    exec(
      http("addChairToCart")
        .post(shopizerApi + "cart/?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"chair1","quantity":1}""")).asJson
        .check(jsonPath("$.products[0].refSku").is("chair1"))
    )
  }
}

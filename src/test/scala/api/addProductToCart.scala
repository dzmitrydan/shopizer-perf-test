package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object addProductToCart {

  def addProductToCart(prod: String): ChainBuilder = {
    exec(
      http(s"add$prod" + "ToCart")
        .put(shopizerApi + "cart/" + orderId + "?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"table1","quantity":1}""")).asJson
    )
  }

  def getInfoAboutOrder(prod: String): ChainBuilder = {
    exec(
      http(s"getInfoAbout$prod")
        .get(shopizerApi + "cart/" + orderId + "?lang=en")
    )
  }

  def getInfoAboutOrderDefault(): ChainBuilder = {
    exec(
      http("getInfoAboutOrderDefault")
        .get(shopizerApi + "cart/" + orderId + "?store=DEFAULT")
    )
  }

  def addDefaultChairToCart(): ChainBuilder = {
    exec(
      http("addDefaultChairToCart")
        .post(shopizerApi + "/cart/?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"chair1","quantity":1}""")).asJson
        .check(jsonPath("$.products[0].description.description").is("Chair from Thailand"))
    )
  }
}

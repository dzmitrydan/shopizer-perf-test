package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object categoryProduct {

  def categoryProduct(prod: String): ChainBuilder = {
    exec(
      http(s"categoryProduct#$prod")
        .get(shopizerApi + s"category/$prod?store=DEFAULT&lang=en")
    )
  }

  def categoryManufacturersProduct(prod: String): ChainBuilder = {
    exec(
      http(s"categoryManufacturersProduct#$prod")
        .get(shopizerApi + s"category/$prod/manufacturers/?store=DEFAULT&lang=en")
    )
  }

  def productsStoreCategoryProduct(prod: String): ChainBuilder = {
    exec(
      http(s"productsStoreCategoryProduct#$prod")
        .get(shopizerApi + s"products/?&store=DEFAULT&lang=en&page=0&count=15&category=$prod")
    )
  }
}

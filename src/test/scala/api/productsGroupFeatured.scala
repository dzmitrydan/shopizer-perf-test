package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object productsGroupFeatured {
  def productsGroupFeatured(): ChainBuilder = {
    exec(
      http("productsGroupFeatured")
        .get(shopizerApi + "products/group/FEATURED_ITEM?store=DEFAULT&lang=en")
    )
  }
}

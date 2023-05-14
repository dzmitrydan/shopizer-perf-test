package simulation

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.ShopizerAddProductToCart._
import scala.language.postfixOps

class ShopizerPerfTest extends Simulation {

  //mvn clean gatling:test
  //mvn clean gatling:test -DUsers=100 -DDuration=5

  setUp(
    scnAddProductsToCart.inject(atOnceUsers(30), rampUsers(200).during(1800)))
    .maxDuration(1800)
    .protocols(httpProtocol)
}

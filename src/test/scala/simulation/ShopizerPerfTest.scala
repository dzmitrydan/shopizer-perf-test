package simulation

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.ShopizerAddProductToCart._

class ShopizerPerfTest extends Simulation {

  //mvn clean gatling:test
  //mvn clean gatling:test -DUsers=100

  setUp(
    scnAddProductsToCart.inject(rampUsers(usersNumber).during(60))
  ).protocols(httpProtocol)
}

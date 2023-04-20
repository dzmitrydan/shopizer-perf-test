package simulation

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.ShopizerAddProductToCart._
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class ShopizerPerfTest extends Simulation {

  //mvn clean gatling:test
  //mvn clean gatling:test -DUsers=100

  setUp(
    scnAddProductsToCart.inject(constantConcurrentUsers(usersNumber).during(testDuration minutes))
  ).protocols(httpProtocol)
}

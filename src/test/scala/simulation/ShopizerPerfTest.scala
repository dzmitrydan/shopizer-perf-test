package simulation

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.ShopizerAddProductToCart._

class ShopizerPerfTest extends Simulation {

  //mvn clean gatling:test
  //mvn clean gatling:test -DUsers=100

  setUp(
    scnOpenHomePage.inject(atOnceUsers(usersNumber)),
    scnAddTableToCart.inject(atOnceUsers(usersNumber)),
    scnAddChairToCart.inject(atOnceUsers((usersNumber * 0.5).toInt)),
    scnActionsWithCart.inject(atOnceUsers((usersNumber * 0.3).toInt))
  ).protocols(httpProtocol)
}

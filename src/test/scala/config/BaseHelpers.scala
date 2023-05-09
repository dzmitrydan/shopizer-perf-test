package config


import io.gatling.core.structure.ChainBuilder
import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.http.protocol.HttpProtocolBuilder

object BaseHelpers {

  val usersNumber = System.getProperty("Users", "3").toInt
  val shopizerUrl = "http://localhost:8080/"
  val shopizerApi = shopizerUrl + "api/v1/"
  val testDuration = System.getProperty("Duration", "10").toInt

  def thinkTimer(Min :Int = 2, Max :Int = 5): ChainBuilder = {
    pause(Min, Max)
  }

  val httpProtocol: HttpProtocolBuilder = http
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5/0 (Macintosh; Intel Mac OS X 13_2_6) AppleWebKit/537/36 (KHTML. like Gecko) Chrome/73/0/368/86 Safari/537/36")
}

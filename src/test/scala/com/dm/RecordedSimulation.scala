package com.dm

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://connectivitycheck.gstatic.com")
		.inferHtmlResources()
		.acceptEncodingHeader("gzip")
		.connectionHeader("close")
		.userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.32 Safari/537.36")

	val uri1 = "http://www.google.com/gen_204"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/generate_204")
			.resources(http("request_1")
			.get(uri1)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
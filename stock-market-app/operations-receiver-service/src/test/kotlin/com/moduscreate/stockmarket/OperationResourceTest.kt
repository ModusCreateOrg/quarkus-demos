package com.moduscreate.stockmarket

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class OperationResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/operation")
          .then()
             .statusCode(200)
             .body(`is`("hello"))
    }

}
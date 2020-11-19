package com.moduscreate.stockmarket

import io.quarkus.vertx.web.Body
import io.quarkus.vertx.web.Route
import io.quarkus.vertx.web.RouteBase
import io.vertx.core.http.HttpMethod

@RouteBase(path = "/operations")
class OperationResource(private val operations: StockOperations) {

    @Route(path = "/", methods = [HttpMethod.POST], produces = ["application/json"], consumes = ["application/json"])
    fun execute(@Body stockOperation: StockOperation) = operations.execute(stockOperation)

}
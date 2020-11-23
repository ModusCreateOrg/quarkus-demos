package com.moduscreate.stockmarket

import io.quarkus.vertx.web.Body
import io.quarkus.vertx.web.Route
import io.quarkus.vertx.web.RouteBase
import io.smallrye.mutiny.Uni
import io.vertx.core.http.HttpMethod
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter

@RouteBase(path = "/operations")
class OperationResource(
        private val operations: StockOperations,
        @Channel("stocksOperations") private val emitter: Emitter<StockOperation>
) {

    @Route(path = "/", methods = [HttpMethod.POST], produces = ["application/json"], consumes = ["application/json"])
    fun execute(@Body stockOperation: StockOperation): Uni<StockOperation> {
        emitter.send(stockOperation)
        return operations.execute(stockOperation)
    }


}
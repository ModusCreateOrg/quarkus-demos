package com.moduscreate.stockmarket

import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class StockOperationIncoming(
        private val stockOperations: StockOperations
) {

    @Incoming("stockOperations")
    fun receive(stockOperationJson: StockOperation): Uni<StockOperation> {
        println("stockOperation ${stockOperationJson.stock}")
        return stockOperations.execute(stockOperationJson)
    }

}
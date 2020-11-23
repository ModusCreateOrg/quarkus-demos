package com.moduscreate.stockmarket

import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Outgoing
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class StockOperationsProducer {

    @Incoming("stocksOperations")
    @Outgoing("stocksOperations")
    fun produce(stockOperation: StockOperation): StockOperation {
        return stockOperation
    }

}
package com.moduscreate.stockmarket

import io.smallrye.reactive.messaging.kafka.KafkaRecord
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Outgoing
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class StockOperationsProducer {

    @Incoming("stockOperations")
    @Outgoing("stockOperations")
    fun produce(stockOperation: StockOperation): StockOperation =
            stockOperation.also {
                println("Sending transaction with description ${stockOperation.stock}")
            }

}
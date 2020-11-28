package com.moduscreate.stockmarket

import io.smallrye.mutiny.Uni

interface StockOperations {

    fun execute(stockOperation: StockOperation): Uni<StockOperation>

}
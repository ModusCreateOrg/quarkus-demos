package com.moduscreate.stockmarket

import io.smallrye.mutiny.Uni
import io.vertx.mutiny.pgclient.PgPool
import io.vertx.mutiny.sqlclient.Tuple

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class StockOperationsImpl(private val client: PgPool) : StockOperations {

    override fun execute(stockOperation: StockOperation): Uni<StockOperation> =
            client.preparedQuery("""
                INSERT INTO stock_operation (stock, operation_type, quantity, value) VALUES ($1, $2, $3, $4) RETURNING id
            """).execute(Tuple.of(stockOperation.stock, stockOperation.operationType, stockOperation.quantity, stockOperation.value))
                    .onItem().transform { stockOperation.id(it.iterator().next().getUUID("id")) }

}
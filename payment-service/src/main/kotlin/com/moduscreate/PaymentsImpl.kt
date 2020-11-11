package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import io.vertx.mutiny.pgclient.PgPool
import io.vertx.mutiny.sqlclient.Tuple

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PaymentsImpl(private val client: PgPool) : Payments {

    override fun save(payment: Payment): Uni<Payment> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: String): Uni<Payment> =
            client.preparedQuery("""
                SELECT id, order_id, user_id, value
                  FROM payment
                 WHERE id = $1
            """).execute(Tuple.of(id))
                    .onItem().transform { it.iterator() }
                    .onItem().transform { if (it.hasNext()) Payment.from(it.next()) else null }

    override fun findAll(): Multi<Payment> =
            client.query("""
                SELECT id, order_id, user_id, value
                  FROM payment
            """).execute().onItem().transformToMulti { Multi.createFrom().iterable(it) }
                    .onItem().transform { Payment.from(it) }

}
package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import io.vertx.mutiny.pgclient.PgPool
import io.vertx.mutiny.sqlclient.Tuple
import java.util.*

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PaymentsImpl(private val client: PgPool) : Payments {

    override fun create(payment: Payment): Uni<Payment> =
            client.preparedQuery("""
                INSERT INTO payment (order_id, user_id, value) VALUES ($1, $2, $3) RETURNING id
            """).execute(Tuple.of(payment.orderId, payment.userId, payment.value))
                    .onItem().transform { payment.id(it.iterator().next().getUUID("id")) }

    override fun update(id: UUID, payment: Payment): Uni<Payment> =
            client.preparedQuery("""
                UPDATE payment
                   SET order_id = $1,
                       user_id = $2, 
                       value = $3
                 WHERE id = $4  
            """).execute(Tuple.of(payment.orderId, payment.userId, payment.value, id))
                    .onItem().transform { payment }

    override fun delete(id: UUID): Uni<Boolean> =
            client.preparedQuery("DELETE FROM payment WHERE id = $1").execute(Tuple.of(id))
                    .onItem().transform { it.rowCount() == 1 }

    override fun findOne(id: UUID): Uni<Payment> =
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
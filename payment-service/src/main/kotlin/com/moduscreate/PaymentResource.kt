package com.moduscreate

import io.quarkus.vertx.web.Body
import io.quarkus.vertx.web.Param
import io.quarkus.vertx.web.ReactiveRoutes
import io.quarkus.vertx.web.Route
import io.quarkus.vertx.web.RouteBase
import io.vertx.core.http.HttpMethod.DELETE
import io.vertx.core.http.HttpMethod.GET
import io.vertx.core.http.HttpMethod.POST
import io.vertx.core.http.HttpMethod.PUT

@RouteBase(path = "/payments")
class PaymentResource(
        private val payments: Payments
) {

    @Route(path = "", methods = [GET], produces = ["application/json"])
    fun findAll() = ReactiveRoutes.asJsonArray(payments.findAll())

    @Route(path = ":id", methods = [GET], produces = ["application/json"])
    fun findOne(@Param id: String) = payments.findOne(id)

    @Route(path = "", methods = [POST], produces = ["application/json"], consumes = ["application/json"])
    fun create(@Body payment: Payment) = payments.create(payment)

    @Route(path = ":id", methods = [PUT], produces = ["application/json"], consumes = ["application/json"])
    fun update(@Param id: String, @Body payment: Payment) = payments.update(id, payment)

    @Route(path = ":id", methods = [DELETE], produces = ["application/json"])
    fun deleteOne(@Param id: String) = payments.delete(id)

}
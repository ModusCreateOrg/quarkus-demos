package com.moduscreate

import io.quarkus.vertx.web.ReactiveRoutes
import io.quarkus.vertx.web.Route
import io.quarkus.vertx.web.RouteBase
import io.vertx.core.http.HttpMethod.GET

@RouteBase(path = "/payments")
class PaymentResource(private val payments: Payments) {

    @Route(path = "", methods = [GET], produces = ["application/json"])
    fun findAll() = ReactiveRoutes.asJsonArray(payments.findAll())

}
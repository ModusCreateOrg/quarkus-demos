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
import java.util.*

@RouteBase(path = "/bank-accounts")
class BankAccountResource(
        private val bankAccounts: BankAccounts
) {

    @Route(path = "", methods = [GET], produces = ["application/json"])
    fun findAll() = ReactiveRoutes.asJsonArray(bankAccounts.findAll())

    @Route(path = ":id", methods = [GET], produces = ["application/json"])
    fun findOne(@Param id: String) = bankAccounts.findOne(UUID.fromString(id))

    @Route(path = "", methods = [POST], produces = ["application/json"], consumes = ["application/json"])
    fun create(@Body bankAccount: BankAccount) = bankAccounts.create(bankAccount)

    @Route(path = ":id", methods = [PUT], produces = ["application/json"], consumes = ["application/json"])
    fun update(@Param id: String, @Body bankAccount: BankAccount) = bankAccounts.update(UUID.fromString(id), bankAccount)

    @Route(path = ":id", methods = [DELETE], produces = ["application/json"])
    fun deleteOne(@Param id: String) = bankAccounts.delete(UUID.fromString(id))

}
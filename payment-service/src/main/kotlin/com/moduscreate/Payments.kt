package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni

interface Payments {

    fun create(payment: Payment): Uni<Payment>
    fun update(id: String, payment: Payment): Uni<Payment>
    fun delete(id: String): Uni<Boolean>
    fun findOne(id: String): Uni<Payment>
    fun findAll(): Multi<Payment>

}
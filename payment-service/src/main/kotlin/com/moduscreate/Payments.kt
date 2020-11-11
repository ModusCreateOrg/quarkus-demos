package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni

interface Payments {

    fun save(payment: Payment): Uni<Payment>
    fun findOne(id: String): Uni<Payment>
    fun findAll(): Multi<Payment>

}
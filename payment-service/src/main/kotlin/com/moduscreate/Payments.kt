package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import java.util.*

interface Payments {

    fun create(payment: Payment): Uni<Payment>
    fun update(id: UUID, payment: Payment): Uni<Payment>
    fun delete(id: UUID): Uni<Boolean>
    fun findOne(id: UUID): Uni<Payment>
    fun findAll(): Multi<Payment>

}
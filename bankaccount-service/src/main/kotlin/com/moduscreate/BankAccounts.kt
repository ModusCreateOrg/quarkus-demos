package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import java.util.*

interface BankAccounts {

    fun create(bankAccount: BankAccount): Uni<BankAccount>
    fun update(id: UUID, bankAccount: BankAccount): Uni<BankAccount>
    fun delete(id: UUID): Uni<Boolean>
    fun findOne(id: UUID): Uni<BankAccount>
    fun findAll(): Multi<BankAccount>

}
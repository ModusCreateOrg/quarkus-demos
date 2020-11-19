package com.moduscreate

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import io.vertx.mutiny.pgclient.PgPool
import io.vertx.mutiny.sqlclient.Row
import io.vertx.mutiny.sqlclient.Tuple
import java.util.*

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BankAccountsImpl(private val client: PgPool) : BankAccounts {

    override fun create(bankAccount: BankAccount): Uni<BankAccount> =
            client.preparedQuery("""
                INSERT INTO bank_account (user_id, name, active) VALUES ($1, $2, $3) RETURNING id
            """).execute(fromBankAccount(bankAccount))
                    .onItem().transform { bankAccount.id(it.iterator().next().getUUID("id")) }

    override fun update(id: UUID, bankAccount: BankAccount): Uni<BankAccount> =
            client.preparedQuery("""
                UPDATE bank_account
                   SET user_id = $1,
                       name = $2, 
                       active = $3
                 WHERE id = $4  
            """).execute(fromBankAccount(bankAccount))
                    .onItem().transform { bankAccount }

    override fun delete(id: UUID): Uni<Boolean> =
            client.preparedQuery("DELETE FROM bank_account WHERE id = $1").execute(Tuple.of(id))
                    .onItem().transform { it.rowCount() == 1 }

    override fun findOne(id: UUID): Uni<BankAccount> =
            client.preparedQuery("""
                SELECT id, user_id, name, active
                  FROM bank_account
                 WHERE id = $1
            """).execute(Tuple.of(id))
                    .onItem().transform { it.iterator() }
                    .onItem().transform { if (it.hasNext()) toBankAccount(it.next()) else null }

    override fun findAll(): Multi<BankAccount> =
            client.query("""
                SELECT id, user_id, name, active
                  FROM bank_account
            """).execute().onItem().transformToMulti { Multi.createFrom().iterable(it) }
                    .onItem().transform { toBankAccount(it) }

    private fun fromBankAccount(bankAccount: BankAccount) =
            bankAccount.let {
                if (it.id == null) Tuple.of(it.userId, it.name, it.active)
                else Tuple.of(it.userId, it.name, it.active, it.id)
            }

    private fun toBankAccount(row: Row): BankAccount =
            row.let {
                BankAccount(
                        id = it.getUUID("id"),
                        name = it.getString("name"),
                        userId = it.getString("user_id"),
                        active = it.getBoolean("active")
                )
            }

}
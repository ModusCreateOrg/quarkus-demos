package com.moduscreate

import com.fasterxml.jackson.annotation.JsonProperty
import io.vertx.mutiny.sqlclient.Row
import java.util.*

data class Payment(
        @JsonProperty("id")
        val id: UUID? = null,

        @JsonProperty("orderId")
        val orderId: String,

        @JsonProperty("userId")
        val userId: String,

        @JsonProperty("value")
        val value: Double
) {

    fun id(id: UUID) = copy(id = id)

    companion object {

        @JvmStatic
        fun from(row: Row): Payment =
                row.let {
                    Payment(
                            id = it.getUUID("id"),
                            orderId = it.getString("order_id"),
                            userId = it.getString("user_id"),
                            value = it.getDouble("value")
                    )
                }

    }

}
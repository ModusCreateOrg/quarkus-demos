package com.moduscreate

import io.vertx.mutiny.sqlclient.Row

data class Payment(
        val id: String,
        val orderId: String,
        val userId: String,
        val value: Double
) {

    companion object {

        @JvmStatic
        fun from(row: Row): Payment =
                row.let {
                    Payment(
                            id = it.getString("id"),
                            orderId = it.getString("order_id"),
                            userId = it.getString("user_id"),
                            value = it.getDouble("value")
                    )
                }

    }

}
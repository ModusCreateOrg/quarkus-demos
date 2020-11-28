package com.moduscreate.stockmarket

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class StockOperation(
        @JsonProperty("id")
        val id: UUID? = null,

        @JsonProperty("stock")
        val stock: String,

        @JsonProperty("operationType")
        val operationType: String,

        @JsonProperty("quantity")
        val quantity: Int,

        @JsonProperty("value")
        val value: Double

) {

    fun id(id: UUID) = copy(id = id)

}
package com.moduscreate

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class BankAccount(
        @JsonProperty("id")
        val id: UUID? = null,

        @JsonProperty("name")
        val name: String,

        @JsonProperty("userId")
        val userId: String,

        @JsonProperty("active")
        val active: Boolean = true
) {

    fun id(id: UUID) = copy(id = id)

}
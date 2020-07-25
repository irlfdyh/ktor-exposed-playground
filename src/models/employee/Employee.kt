package com.playground.ktor.models.employee

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    var id: Int? = null,
    var name: String,
    var phone: String,
    var address: String
)
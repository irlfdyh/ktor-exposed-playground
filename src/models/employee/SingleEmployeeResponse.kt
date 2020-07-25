package com.playground.ktor.models.employee

import kotlinx.serialization.Serializable

@Serializable
data class SingleEmployeeResponse(
    var message: String = "Employee",
    var data: Employee?
)
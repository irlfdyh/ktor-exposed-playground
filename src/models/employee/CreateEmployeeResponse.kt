package com.playground.ktor.models.employee

import kotlinx.serialization.Serializable

@Serializable
data class CreateEmployeeResponse(
    var message: String = "Data Created",
    var data: Employee?
)
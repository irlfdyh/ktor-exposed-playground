package com.playground.ktor.models.employee

import kotlinx.serialization.Serializable

@Serializable
data class ListEmployeeResponse(
    var message: String = "List of Employee",
    var data: List<Employee>?
)
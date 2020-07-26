package com.playground.ktor.models.employee.httpResponse

import com.playground.ktor.models.employee.Employee
import kotlinx.serialization.Serializable

@Serializable
data class CreateEmployeeResponse(
    var message: String = "Data Created",
    var data: Employee?
)
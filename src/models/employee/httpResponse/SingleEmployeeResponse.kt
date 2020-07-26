package com.playground.ktor.models.employee.httpResponse

import com.playground.ktor.models.employee.Employee
import kotlinx.serialization.Serializable

@Serializable
data class SingleEmployeeResponse(
    var message: String = "Employee",
    var data: Employee?
)
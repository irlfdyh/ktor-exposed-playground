package com.playground.ktor.models.employee.httpResponse

import com.playground.ktor.models.employee.Employee
import kotlinx.serialization.Serializable

@Serializable
data class ListEmployeeResponse(
    var message: String = "List of Employee",
    var data: List<Employee>?
)
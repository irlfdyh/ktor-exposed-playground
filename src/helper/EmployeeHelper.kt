package com.playground.ktor.helper

import com.playground.ktor.models.employee.Employee
import com.playground.ktor.util.EMPLOYEE_FIELD_ADDRESS
import com.playground.ktor.util.EMPLOYEE_FIELD_NAME
import com.playground.ktor.util.EMPLOYEE_FIELD_PHONE
import io.ktor.http.content.MultiPartData
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun handleEmployee(partData: MultiPartData): Employee {
    val employee = Employee(null, "", "", "")
    withContext(Dispatchers.IO) {
        partData.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    when(part.name) {
                        EMPLOYEE_FIELD_NAME -> employee.name = part.value
                        EMPLOYEE_FIELD_PHONE -> employee.phone = part.value
                        EMPLOYEE_FIELD_ADDRESS -> employee.address = part.value
                        else -> println("Illegal part name")
                    }
                }
            }
        }
    }
    return employee
}
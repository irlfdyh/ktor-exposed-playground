package com.playground.ktor.data.repository

import com.playground.ktor.models.Employee

abstract class EmployeeRepository {
    abstract suspend fun getAllEmployee(): List<Employee>
    abstract suspend fun getSingleEmployee()
    abstract suspend fun postEmployee(name: String, phone: String, address: String)
    abstract suspend fun updateEmployee()
    abstract suspend fun deleteEmployee()
}
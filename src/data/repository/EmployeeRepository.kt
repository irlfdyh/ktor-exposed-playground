package com.playground.ktor.data.repository

import com.playground.ktor.models.employee.Employee

abstract class EmployeeRepository {
    abstract suspend fun getAllEmployee(): List<Employee>
    abstract suspend fun getSingleEmployee(employeeId: Int): Employee
    abstract suspend fun postEmployee(name: String, phone: String, address: String): Int?
    abstract suspend fun updateEmployee(id: Int, name: String, phone: String, address: String)
    abstract suspend fun deleteEmployee(id: Int)
}
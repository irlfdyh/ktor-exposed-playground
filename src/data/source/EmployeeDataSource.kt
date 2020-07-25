package com.playground.ktor.data.source

import com.playground.ktor.data.repository.EmployeeRepository
import com.playground.ktor.models.employee.Employee
import com.playground.ktor.models.employee.EmployeeTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class EmployeeDataSource : EmployeeRepository() {

    override suspend fun getAllEmployee(): List<Employee> {
        val employee = mutableListOf<Employee>()
        transaction {
            EmployeeTable.selectAll().forEach {
                employee.add(
                    Employee(
                        id = it[EmployeeTable.id].value,
                        name = it[EmployeeTable.name],
                        phone = it[EmployeeTable.phone],
                        address = it[EmployeeTable.address]
                ))
            }
        }
        return employee
    }

    override suspend fun getSingleEmployee(employeeId: Int): Employee {
        val employee = Employee(null, "", "", "")
        transaction {
            EmployeeTable.select { EmployeeTable.id.eq(employeeId) }.forEach {
                employee.id = it[EmployeeTable.id].value
                employee.name = it[EmployeeTable.name]
                employee.phone = it[EmployeeTable.phone]
                employee.address = it[EmployeeTable.address]
            }
        }
        return employee
    }

    override suspend fun postEmployee(name: String, phone: String, address: String): Int? {
        var currentId: Int? = null
        transaction {
            val request = EmployeeTable.insertAndGetId{
                it[EmployeeTable.name] = name
                it[EmployeeTable.phone] = phone
                it[EmployeeTable.address] = address
            }
            currentId = request.value
        }
        return currentId
    }
    override suspend fun updateEmployee(id: Int, name: String, phone: String, address: String) {
        transaction {
            EmployeeTable.update({EmployeeTable.id.eq(id)}) {
                it[EmployeeTable.name] = name
                it[EmployeeTable.phone] = phone
                it[EmployeeTable.address] = address
            }
        }
    }

    override suspend fun deleteEmployee(id: Int) {
        transaction {
            EmployeeTable.deleteWhere{
                EmployeeTable.id.eq(id)
            }
        }
    }
}
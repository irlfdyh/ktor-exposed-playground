package com.playground.ktor.data.source

import com.playground.ktor.DatabaseSettings
import com.playground.ktor.data.repository.EmployeeRepository
import com.playground.ktor.models.Employee
import com.playground.ktor.models.EmployeeTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

class EmployeeDataSource : EmployeeRepository() {

    override suspend fun getAllEmployee(): List<Employee> {
        val employee = listOf(
            Employee(1, "Ahmad", "085697855", "Jl.Maskumamnbang"),
            Employee(2, "Salih", "085697855", "Jl.Kertadara"),
            Employee(1, "Solih", "085697855", "Jl.Kertawijaya"),
            Employee(1, "Memet", "085697855", "Jl.Darmajaya")
        )
        return employee
    }

    override suspend fun getSingleEmployee() {
        TODO("Not yet implemented")
    }

    override suspend fun postEmployee(name: String, phone: String, address: String) {
        transaction {
            EmployeeTable.insertAndGetId{
                it[EmployeeTable.name] = name
                it[EmployeeTable.phone] = phone
                it[EmployeeTable.address] = address
            }
        }
    }
    override suspend fun updateEmployee() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEmployee() {
        TODO("Not yet implemented")
    }
}
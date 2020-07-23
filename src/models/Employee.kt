package com.playground.ktor.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object EmployeeTable : IntIdTable("employed") {
    val name: Column<String> = varchar("name", 50)
    val phone: Column<String> = varchar("phone", 15)
    val address: Column<String> = varchar("address", 100)
}

@Serializable
data class Employee(
    var id: Int,
    var name: String,
    var phone: String,
    var address: String
)

//class Employee(id: EntityID<Int>) : IntEntity(id) {
//    companion object : IntEntityClass<Employee>(EmployeeTable)
//    var name by EmployeeTable.name
//    var phone by EmployeeTable.phone
//    var address by EmployeeTable.address
//}
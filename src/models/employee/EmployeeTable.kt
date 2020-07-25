package com.playground.ktor.models.employee

import com.playground.ktor.util.EMPLOYEE_FIELD_ADDRESS
import com.playground.ktor.util.EMPLOYEE_FIELD_NAME
import com.playground.ktor.util.EMPLOYEE_FIELD_PHONE
import com.playground.ktor.util.EMPLOYEE_TABLE_NAME
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object EmployeeTable : IntIdTable(EMPLOYEE_TABLE_NAME) {
    val name: Column<String> = varchar(EMPLOYEE_FIELD_NAME, 50)
    val phone: Column<String> = varchar(EMPLOYEE_FIELD_PHONE, 15)
    val address: Column<String> = varchar(EMPLOYEE_FIELD_ADDRESS, 100)
}
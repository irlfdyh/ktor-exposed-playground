package com.playground.ktor.models.purchase

import com.playground.ktor.models.employee.EmployeeTable
import com.playground.ktor.util.*
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime

object PurchaseTable : IntIdTable(PURCHASE_TABLE_NAME) {
    val employeeId = reference(PURCHASE_FIELD_EMPLOYEE_ID, EmployeeTable)
    val amount = integer(PURCHASE_FIELD_AMOUNT)
    val priceTotal = long(PURCHASE_FIELD_PRICE_TOTAL)
    val purchaseDate = datetime(PURCHASE_FIELD_PURCHASE_DATE)
}
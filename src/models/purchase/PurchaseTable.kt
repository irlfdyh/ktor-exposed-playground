package com.playground.ktor.models.purchase

import com.playground.ktor.models.employee.EmployeeTable
import com.playground.ktor.util.PURCHASE_TABLE_NAME
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime

object PurchaseTable : IntIdTable(PURCHASE_TABLE_NAME) {
    val employeeId = reference("employee_id", EmployeeTable)
    val amount = integer("amount")
    val priceTotal = long("price_total")
    val purchaseDate = datetime("purchase_datetime")
}
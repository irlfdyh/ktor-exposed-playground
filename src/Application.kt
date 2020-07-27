package com.playground.ktor

import com.playground.ktor.data.source.EmployeeDataSource
import com.playground.ktor.models.employee.EmployeeTable
import com.playground.ktor.models.product.ProductTable
import com.playground.ktor.models.productCategory.ProductCategoryTable
import com.playground.ktor.models.purchase.PurchaseTable
import com.playground.ktor.models.purchaseProduct.PurchaseProductTable
import com.playground.ktor.routes.registerEmployeeRoutes
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.serialization.json
import io.ktor.server.netty.EngineMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    runBlocking {
        withContext(Dispatchers.IO) {
            initializeDatabase()
            initializeTables()
        }
    }
    initializeEngine(args)
}

private fun initializeEngine(args: Array<String>) {
    EngineMain.main(args)
}

private fun initializeDatabase() {
    DatabaseSettings.initMySqlDatabase
}

private fun initializeTables() {
    transaction {
        SchemaUtils.create(EmployeeTable)
        SchemaUtils.create(PurchaseTable)
        SchemaUtils.create(ProductCategoryTable)
        SchemaUtils.create(ProductTable)
        SchemaUtils.create(PurchaseProductTable)
    }
}

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val dataSource = EmployeeDataSource()
    install(ContentNegotiation) {
        json()
    }
    registerEmployeeRoutes(dataSource)
}




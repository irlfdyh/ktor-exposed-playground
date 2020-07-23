package com.playground.ktor

import com.playground.ktor.data.source.EmployeeDataSource
import com.playground.ktor.models.EmployeeTable
import com.playground.ktor.routes.registerEmployeeRoutes
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.serialization.json
import io.ktor.server.netty.EngineMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    runBlocking {
        withContext(Dispatchers.IO) {
            DatabaseSettings.initMySqlDatabase
            transaction {
                SchemaUtils.create(EmployeeTable)
            }
            println("called")
        }
    }
    EngineMain.main(args)
}

fun initEngine() {

}

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val dataSource = EmployeeDataSource()
    install(ContentNegotiation) {
        json()
    }
    registerEmployeeRoutes(dataSource)
}

private fun initializeTables() {
    transaction {
        SchemaUtils.create(EmployeeTable)
    }
}


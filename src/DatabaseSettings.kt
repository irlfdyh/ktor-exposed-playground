package com.playground.ktor

import org.jetbrains.exposed.sql.Database

object DatabaseSettings {
    val initMySqlDatabase by lazy {
        val url = "jdbc:mysql://localhost:3306/market_database"
        val driver = "com.mysql.jdbc.Driver"
        Database.connect(url, driver, "root", "")
    }
}
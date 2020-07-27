package com.playground.ktor.models.productCategory

import com.playground.ktor.util.CATEGORY_FIELD_DATE
import com.playground.ktor.util.CATEGORY_FIELD_NAME
import com.playground.ktor.util.CATEGORY_TABLE_NAME
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime

object ProductCategoryTable : IntIdTable(CATEGORY_TABLE_NAME) {
    val name: Column<String> = varchar(CATEGORY_FIELD_NAME, 25)
    val date = datetime(CATEGORY_FIELD_DATE)
}
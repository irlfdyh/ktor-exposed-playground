package com.playground.ktor.models.product

import com.playground.ktor.models.productCategory.ProductCategoryTable
import com.playground.ktor.util.PRODUCT_FIELD_ADDED_DATE
import com.playground.ktor.util.PRODUCT_FIELD_CATEGORY_ID
import com.playground.ktor.util.PRODUCT_FIELD_NAME
import com.playground.ktor.util.PRODUCT_TABLE_NAME
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.date

object ProductTable : IntIdTable(PRODUCT_TABLE_NAME) {
    val categoryId = reference(PRODUCT_FIELD_CATEGORY_ID, ProductCategoryTable)
    val name = varchar(PRODUCT_FIELD_NAME, 50)
    val date = date(PRODUCT_FIELD_ADDED_DATE)
}
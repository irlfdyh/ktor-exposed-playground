package com.playground.ktor.models.purchaseProduct

import com.playground.ktor.models.product.ProductTable
import com.playground.ktor.models.purchase.PurchaseTable
import com.playground.ktor.util.PURCHASE_PRODUCT_FIELD_PRODUCT_ID
import com.playground.ktor.util.PURCHASE_PRODUCT_FIELD_PURCHASE_ID
import com.playground.ktor.util.PURCHASE_PRODUCT_TABLE_NAME
import org.jetbrains.exposed.dao.id.IntIdTable

object PurchaseProductTable : IntIdTable(PURCHASE_PRODUCT_TABLE_NAME) {
    val purchaseId = reference(PURCHASE_PRODUCT_FIELD_PURCHASE_ID, PurchaseTable)
    val productId = reference(PURCHASE_PRODUCT_FIELD_PRODUCT_ID, ProductTable)
}
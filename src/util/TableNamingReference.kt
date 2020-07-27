package com.playground.ktor.util

const val EMPLOYEE_TABLE_NAME = "employee"
const val EMPLOYEE_FIELD_NAME = "name"
const val EMPLOYEE_FIELD_PHONE = "phone"
const val EMPLOYEE_FIELD_ADDRESS = "address"

const val PURCHASE_TABLE_NAME = "purchase"
const val PURCHASE_FIELD_EMPLOYEE_ID = "employee_id"
const val PURCHASE_FIELD_AMOUNT = "amount"
const val PURCHASE_FIELD_PRICE_TOTAL = "price_total"
const val PURCHASE_FIELD_PURCHASE_DATE = "purchase_datetime"

const val CATEGORY_TABLE_NAME = "product_category"
const val CATEGORY_FIELD_NAME = "name"
const val CATEGORY_FIELD_DATE = "created_date"

const val PRODUCT_TABLE_NAME = "product"
const val PRODUCT_FIELD_NAME = "name"
const val PRODUCT_FIELD_CATEGORY_ID = "category_id"
const val PRODUCT_FIELD_ADDED_DATE = "created_date"

const val PURCHASE_PRODUCT_TABLE_NAME = "purchase_product"
const val PURCHASE_PRODUCT_FIELD_PURCHASE_ID = "purchase_id"
const val PURCHASE_PRODUCT_FIELD_PRODUCT_ID = "product_id"
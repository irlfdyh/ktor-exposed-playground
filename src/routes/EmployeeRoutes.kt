package com.playground.ktor.routes

import com.playground.ktor.data.repository.EmployeeRepository
import com.playground.ktor.data.source.EmployeeDataSource
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun Application.registerEmployeeRoutes(dataSource: EmployeeDataSource) {
    routing {
        listEmployee(dataSource)
        createEmployee(dataSource)
    }
}

fun Route.listEmployee(dataSource: EmployeeDataSource) {
    get("/employee"){
        call.respond(dataSource.getAllEmployee())
    }
}

fun Route.createEmployee(dataSource: EmployeeDataSource) {
    post("/employee") {
        dataSource.postEmployee()
        call.respondText(
            "Created",
            status = HttpStatusCode.Accepted
        )
    }
}
package com.playground.ktor.routes

import com.playground.ktor.data.source.EmployeeDataSource
import com.playground.ktor.helper.handleEmployee
import com.playground.ktor.models.employee.CreateEmployeeResponse
import com.playground.ktor.models.employee.Employee
import com.playground.ktor.models.employee.ListEmployeeResponse
import com.playground.ktor.models.employee.SingleEmployeeResponse
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receiveMultipart
import io.ktor.response.respond
import io.ktor.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun Application.registerEmployeeRoutes(dataSource: EmployeeDataSource) {
    routing {
        listEmployee(dataSource)
        singleEmployee(dataSource)
        createEmployee(dataSource)
        updateEmployee(dataSource)
        deleteEmployee(dataSource)
    }
}

fun Route.listEmployee(dataSource: EmployeeDataSource) {
    get("/employee"){
        val data = dataSource.getAllEmployee()
        val responseMessage = ListEmployeeResponse(
            data = data
        )
        call.respond(
            status = HttpStatusCode.Accepted,
            message = responseMessage
        )
    }
}

fun Route.singleEmployee(dataSource: EmployeeDataSource) {
    get("/employee/{id}") {
        val id = call.parameters["id"]
        val employee = dataSource.getSingleEmployee(id!!.toInt())
        val responseMessage = if (employee.id != null) {
            SingleEmployeeResponse(
                data = employee
            )
        } else {
            SingleEmployeeResponse(
                message = "No Employee Found with id $id",
                data = null
            )
        }
        call.respond(
            status = HttpStatusCode.Accepted,
            message = responseMessage
        )
    }
}

fun Route.createEmployee(dataSource: EmployeeDataSource) {
    post("/employee") {
        withContext(Dispatchers.IO) {
            val part = call.receiveMultipart()
            val newEmployee = handleEmployee(part)
            val newEmployeeId = dataSource.postEmployee(
                newEmployee.name,
                newEmployee.phone,
                newEmployee.address)

            val responseMessage = CreateEmployeeResponse(
                data = Employee(
                    newEmployeeId,
                    newEmployee.name,
                    newEmployee.phone,
                    newEmployee.address
                )
            )

            call.respond(
                status = HttpStatusCode.Accepted,
                message = responseMessage
            )
        }

    }
}

fun Route.updateEmployee(dataSource: EmployeeDataSource) {
    patch("/employee/{id}") {
        withContext(Dispatchers.IO) {
            val id = call.parameters["id"]?.toInt()
            val part = call.receiveMultipart()
            val updateEmployee = handleEmployee(part)
            dataSource.updateEmployee(id!!,
                updateEmployee.name,
                updateEmployee.phone,
                updateEmployee.address)
            call.respond(
                status = HttpStatusCode.OK,
                message = "Data Updated"
            )
        }
    }
}

fun Route.deleteEmployee(dataSource: EmployeeDataSource) {
    delete("/employee/{id}") {
        withContext(Dispatchers.IO) {
            val id = call.parameters["id"]?.toInt()
            dataSource.deleteEmployee(id!!)
            call.respond(
                status = HttpStatusCode.OK,
                message = "Employee Deleted"
            )
        }
    }
}
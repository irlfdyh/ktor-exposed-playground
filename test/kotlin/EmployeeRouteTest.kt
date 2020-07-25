import com.playground.ktor.DatabaseSettings
import com.playground.ktor.module
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.Test
import kotlin.test.assertEquals

class EmployeeRouteTest {

    @Test
    fun getAllEmployee() {
        withTestApplication({ module(true) }) {
            DatabaseSettings.initMySqlDatabase
            handleRequest(HttpMethod.Get, "/employee").apply {
                assertEquals(
                    """{"message":"List of Employee","data":[{"id":1,"name":"User One Name","phone":"089898898898","address":"Jl. UserOne"},{"id":3,"name":"data.name","phone":"data.phone","address":"data.address"},{"id":5,"name":"data.name","phone":"data.phone","address":"data.address"},{"id":6,"name":"data.name","phone":"data.phone","address":"data.address"},{"id":7,"name":"data.name","phone":"data.phone","address":"data.address"},{"id":8,"name":"data.name","phone":"data.phone","address":"data.address"},{"id":9,"name":"data.name","phone":"data.phone","address":"data.address"},{"id":10,"name":"Post Phone","phone":"087456789456","address":"Jl,Perambanan"}]}""",
                    response.content
                )
                assertEquals(HttpStatusCode.Accepted, response.status())
            }
        }
    }

    @Test
    fun getSingleEmployee() {
        withTestApplication({ module(true) }) {
            DatabaseSettings.initMySqlDatabase
            handleRequest(HttpMethod.Get, "/employee/1").apply {
                assertEquals(
                    """{"message":"Employee","data":{"id":1,"name":"User One Name","phone":"089898898898","address":"Jl. UserOne"}}""",
                    response.content)
            }
        }
    }

}
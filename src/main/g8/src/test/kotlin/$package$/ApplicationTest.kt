package $package$

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun `health returns OK`(): Unit = withTestApplication({ module() }) {
        handleRequest(HttpMethod.Get, "/health").apply {
            assertEquals(response.status(), HttpStatusCode.OK)
            assertEquals(response.content, "OK")
        }
    }
}

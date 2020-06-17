package $package$

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module() {
    install(ContentNegotiation) {
        jackson {}
    }

    install(StatusPages) {
        exception<Throwable> { cause ->
            call.respond(HttpStatusCode.InternalServerError)
            throw cause
        }
    }

    routing {
        get("/health") {
            call.respond("OK")
        }
    }
}

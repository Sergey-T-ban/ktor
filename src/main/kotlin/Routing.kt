package com.example

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.staticResources

fun Application.configureRouting() {

    // Встановлюємо StatusPages для обробки винятків
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }

    routing {
        staticResources("/content", "mycontent")

        get("/") {
            call.respondText("Hello World!")
        }

        get("/test1") {
            val text = "<h1>Hello From Ktor</h1>"
            call.respondText(text, ContentType.Text.Html)
        }

        // Кінцева точка для тестування винятків
        get("/error-test") {
            throw IllegalStateException("Too Busy")
        }
    }
}



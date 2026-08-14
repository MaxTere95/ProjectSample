package ru.maxtere.sampleserver

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello from test server")
        }

        get("/{number}") {
            with(call.parameters["number"]) {
                if (this == null) {
                    call.respondText("Number is null")
                } else {
                    call.respondText(this)
                }
            }

        }
    }
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    configureRouting()
}
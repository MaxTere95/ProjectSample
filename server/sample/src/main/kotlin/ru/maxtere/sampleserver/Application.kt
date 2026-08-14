package ru.maxtere.sampleserver

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(
        factory = Netty,
        port = SERVER_PORT,
        host = SERVER_HOST,
        module = Application::module
    ).start(wait = true)
}
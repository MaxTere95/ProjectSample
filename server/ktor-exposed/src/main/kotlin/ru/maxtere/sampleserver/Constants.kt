package ru.maxtere.sampleserver

val SERVER_PORT = System.getenv("SERVER_PORT")?.toIntOrNull() ?: 8080
val SERVER_HOST = System.getenv("SERVER_HOST") ?: "0.0.0.0"
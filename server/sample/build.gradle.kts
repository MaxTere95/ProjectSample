plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    application
}

group = "ru.maxtere.testserver"
version = "1.0.0"
application {
    mainClass.set("ru.maxtere.testserver.ApplicationKt")
    applicationDefaultJvmArgs =
        listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback)
}
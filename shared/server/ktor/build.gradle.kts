plugins {
//    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.multiplatform)
}
//
//group = "ru.maxtere.testserver"
//version = "1.0.0"
//application {
//    mainClass.set("ru.maxtere.testserver.ApplicationKt")
//    applicationDefaultJvmArgs =
//        listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
//}

//dependencies {
//    implementation(projects.sdk.server.network.ktor)
//    implementation(projects.sdk.server.logs.logback)
//}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.shared.common.core)
                implementation(projects.sdk.server.network.ktor)

                api(projects.sdk.server.logs.logback)
            }
        }
    }
}
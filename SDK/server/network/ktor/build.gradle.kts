plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.server.network.ktor.core)
                api(libs.server.network.ktor.netty)
                api(libs.server.network.ktor.negotiation)
                api(libs.client.network.ktor.json)
            }
        }
    }
}
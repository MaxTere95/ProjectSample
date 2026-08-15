plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.ktor.server.core)
                api(libs.ktor.server.netty)
                api(libs.ktor.server.negotiation)
            }
        }
    }
}
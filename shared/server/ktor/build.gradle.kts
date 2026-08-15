plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.shared.common.core)
                api(projects.sdk.server.network.ktor)
                implementation(libs.ktor.kotlin.json)
                implementation(projects.sdk.server.logs.logback)
            }
        }
    }
}
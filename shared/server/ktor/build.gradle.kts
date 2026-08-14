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
                api(projects.sdk.server.logs.logback)
            }
        }
    }
}
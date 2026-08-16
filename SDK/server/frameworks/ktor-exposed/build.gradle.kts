plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.server.network.ktor)
                api(projects.sdk.server.database.exposed)
                api(projects.sdk.server.logs.logback)
            }
        }
    }
}

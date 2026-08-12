plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.client.network.ktor.di.koin)
            }
        }
    }
}

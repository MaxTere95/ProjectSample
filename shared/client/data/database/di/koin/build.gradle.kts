plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.di.koin.core)
                implementation(projects.sdk.client.database.sqlDelight.core)
                implementation(projects.shared.client.data.database.core)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.di.koin.core)
                implementation(projects.shared.client.data.database.core)
                implementation(projects.shared.client.data.repository.core)
                implementation(projects.shared.client.data.repository.impl)
            }
        }
    }
}
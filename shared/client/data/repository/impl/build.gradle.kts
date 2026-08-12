plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.database.sqlDelight.core)
                implementation(projects.shared.client.data.database.core)
                implementation(projects.shared.client.data.repository.core)
            }
        }
    }
}
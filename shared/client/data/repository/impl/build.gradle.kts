plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.shared.client.data.database.core)
                api(projects.shared.client.data.repository.core)
            }
        }
    }
}
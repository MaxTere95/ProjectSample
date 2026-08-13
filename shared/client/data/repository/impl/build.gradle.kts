plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.shared.data.database.core)
                api(projects.shared.data.repository.core)
            }
        }
    }
}
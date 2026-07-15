plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.di.koin.core)
                implementation(projects.shared.components.home.impl)
                implementation(projects.shared.data.repository.core)
            }
        }
    }
}
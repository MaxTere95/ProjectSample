plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.common.di.koin.core)
                implementation(projects.shared.client.components.home.core)
                implementation(projects.shared.client.components.home.impl)
                implementation(projects.shared.client.data.repository.core)
            }
        }
    }
}
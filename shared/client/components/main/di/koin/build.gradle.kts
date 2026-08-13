plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.common.di.koin.core)
                implementation(projects.shared.client.components.main.core)
                implementation(projects.shared.client.components.main.impl)
            }
        }
    }
}
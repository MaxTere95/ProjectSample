plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.di.koin.core)
                implementation(projects.shared.client.components.root.core)
                implementation(projects.shared.client.components.root.impl)
            }
        }
    }
}
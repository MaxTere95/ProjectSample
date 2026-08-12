plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.common.di.koin.core)
                implementation(projects.sdk.client.settings.core)
            }
        }
    }
}

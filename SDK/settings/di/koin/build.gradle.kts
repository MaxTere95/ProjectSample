plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.di.koin.core)
                implementation(projects.sdk.settings.core)
            }
        }
    }
}

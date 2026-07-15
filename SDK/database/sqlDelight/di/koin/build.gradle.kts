plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.di.koin.core)
                implementation(projects.sdk.database.sqlDelight.impl)
                implementation(projects.sdk.platform.core)
            }
        }
    }
}
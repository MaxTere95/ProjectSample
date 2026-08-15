plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
//                implementation(projects.sdk.common.di.koin.core)
                implementation(projects.sdk.client.di.koin.core)
                implementation(projects.sdk.client.database.sqlDelight.core)
                implementation(projects.sdk.client.database.sqlDelight.impl)
                implementation(projects.sdk.client.platform.core)
            }
        }
    }
}
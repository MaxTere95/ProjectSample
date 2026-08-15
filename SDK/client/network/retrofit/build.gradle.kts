plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.client.network.retrofit.core)
                api(libs.client.network.retrofit.resultAdapter)

                api(projects.sdk.common.coroutines)
                api(projects.sdk.client.serialization.gson)
            }
        }
    }
}
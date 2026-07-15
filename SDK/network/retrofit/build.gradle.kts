plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.retrofit)
                api(libs.retrofit.adapters.result)

                api(projects.sdk.coroutines)
                api(projects.sdk.serialization.gson)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.common.datetime)
//                api(projects.sdk.common.serialization.kotlin)
                implementation(projects.sdk.common.serialization.kotlin)
            }
        }
    }
}
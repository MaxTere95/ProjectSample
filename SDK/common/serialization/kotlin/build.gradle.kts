plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.common.kotlin.gradleplugin.serialization)
                api(libs.common.kotlin.serialization.core)
                api(libs.common.kotlin.serialization.json)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.common.coroutines)
                api(projects.shared.common.core)
            }
        }
    }
}
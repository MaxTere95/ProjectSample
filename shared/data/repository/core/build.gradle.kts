plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.coroutines)
                api(projects.shared.common.logic)
            }
        }
    }
}
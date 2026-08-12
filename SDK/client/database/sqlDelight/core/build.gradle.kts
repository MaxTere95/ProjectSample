plugins {
    alias(libs.plugins.kotlin.multiplatform)
}
kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.sqlDelight.core)
                api(libs.sqlDelight.coroutines)
            }
        }
    }
}
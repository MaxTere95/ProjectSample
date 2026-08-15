plugins {
    alias(libs.plugins.kotlin.multiplatform)
}
kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.client.db.sqldelight.core)
                api(libs.client.db.sqldelight.coroutines)
            }
        }
    }
}
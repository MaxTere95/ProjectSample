plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                # Подключаем независимый технический модуль сериализации из общего SDK
                api(projects.sdk.common.serialization.kotlin)
            }
        }
    }
}

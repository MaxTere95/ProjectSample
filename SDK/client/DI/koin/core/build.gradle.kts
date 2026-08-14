// ./SDK/client/DI/koin/core/build.gradle.kts
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.client.di.koin"

        compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                // Базовое ядро DI прокидываем из общего SDK
                api(projects.sdk.common.di.koin.core)

                // 🔌 Сюда переезжают мультиплатформенные Compose-расширения Koin:
                api(libs.client.di.koin.compose)
                api(libs.client.di.koin.compose.viewmodel)
            }
        }
        androidMain {
            dependencies {
                // 🔌 Сюда переезжает Android-специфичный Koin (koin-android)
                api(libs.client.di.koin.android)
            }
        }
    }
}

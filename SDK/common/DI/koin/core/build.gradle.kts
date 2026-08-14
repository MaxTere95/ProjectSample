plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.di.koin"

        // 🛠 Обновили ссылки на переменные конфигурации Android SDK
        compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.common.di.koin.core)
            }
        }
    }
}
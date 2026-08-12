plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.di.koin"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.koin.core)
                api(libs.koin.core.viewmodel)
                api(libs.koin.compose.viewmodel)
                api(libs.koin.compose)
            }
        }
        androidMain {
            dependencies {
                api(libs.koin.android)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

android {
    namespace = "ru.maxtere.sdk.settings"
}

android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

kotlin {
    jvm()
    androidTarget()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.settings.core)
            }
        }
    }
}

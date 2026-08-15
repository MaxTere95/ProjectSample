plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.coroutines"

        compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.common.kotlin.coroutines.core)
            }
        }
        androidMain {
            dependencies {
                api(libs.client.kotlin.coroutines.android)
            }
        }
        jvmMain {
            dependencies {
                api(libs.client.kotlin.coroutines.swing)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.coroutines"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlin.coroutines.core)
            }
        }
        androidMain {
            dependencies {
                api(libs.kotlin.coroutines.android)

            }
        }
        jvmMain {
            dependencies {
                api(libs.kotlin.coroutines.swing)
            }
        }
    }
}
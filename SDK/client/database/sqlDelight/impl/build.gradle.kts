plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.database.sqldelight"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.database.sqlDelight.core)

                implementation(projects.sdk.client.platform.core)
            }
        }

        jvmMain {
            dependencies {
                api(libs.sqlDelight.desktop)
            }
        }

        androidMain {
            dependencies {
                api(libs.sqlDelight.android)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.database.sqldelight"

        compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.database.sqlDelight.core)

                implementation(projects.sdk.client.platform.core)
            }
        }

        androidMain {
            dependencies {
                api(libs.client.db.sqldelight.android)
            }
        }

        jvmMain {
            dependencies {
                api(libs.client.db.sqldelight.desktop)
            }
        }
    }
}
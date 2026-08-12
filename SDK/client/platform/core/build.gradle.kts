plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.platform"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.ui.decompose)
            }
        }

        androidMain {
            dependencies {
                api(libs.android.androidx.activity.compose)
                api(libs.android.androidx.activity.ktx)
                api(libs.android.androidx.appcompat)
            }
        }
    }
}
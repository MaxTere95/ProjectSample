plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.platform"

        compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.ui.decompose)
            }
        }

        androidMain {
            dependencies {
                api(libs.client.platform.android.activity.compose)
                api(libs.client.platform.android.activity.ktx)
                api(libs.client.platform.android.appcompat)
            }
        }
    }
}
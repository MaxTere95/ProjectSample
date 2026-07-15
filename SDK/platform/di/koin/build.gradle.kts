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
                implementation(libs.koin.core)
                implementation(projects.sdk.di.koin.core)
                implementation(projects.sdk.platform.core)
                implementation(projects.sdk.ui.decompose)
            }
        }
    }
}
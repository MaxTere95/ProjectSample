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
                implementation(libs.common.di.koin.core)

//                implementation(projects.sdk.common.di.koin.core)
                implementation(projects.sdk.client.di.koin.core)
                implementation(projects.sdk.client.platform.core)
                implementation(projects.sdk.client.settings.core)
                implementation(projects.sdk.client.ui.decompose)
            }
        }
    }
}
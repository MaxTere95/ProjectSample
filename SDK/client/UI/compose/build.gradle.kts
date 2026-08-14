plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmpLibrary)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "ru.maxtere.sdk.ui.compose"

        compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.client.ui.compose.runtime)
                api(libs.client.ui.compose.ui)
                api(libs.client.ui.compose.foundation)
                api(libs.client.ui.compose.ui.tooling)
                api(libs.client.ui.compose.ui.tooling.preview)
                api(libs.client.ui.compose.material)
                api(libs.client.ui.compose.materialIconsExtended)

//                api(libs.compose.components.resources)
            }
        }

        jvmMain {
            dependencies {
                api(compose.desktop.currentOs)
                api(libs.client.ui.compose.desktop.common)
                api(libs.client.ui.compose.desktop.material)
            }
        }

        androidMain {
            dependencies {
                api(libs.client.platform.android.activity)
            }
        }
    }
}
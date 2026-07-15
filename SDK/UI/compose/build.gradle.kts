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

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.compose.runtime)
                api(libs.compose.ui)
                api(libs.compose.foundation)
                api(libs.compose.ui.tooling)
                api(libs.compose.ui.tooling.preview)
                api(libs.compose.material)
                api(libs.compose.materialIconsExtended)

//                api(libs.compose.components.resources)
            }
        }

        jvmMain {
            dependencies {
                api(compose.desktop.currentOs)
                api(libs.compose.desktop.common)
                api(libs.compose.desktop.material)
            }
        }

        androidMain {
            dependencies {
                api(libs.android.androidx.activity)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.library)
}

android {
    namespace = "ru.maxtere.sdk.network.ktor"
    compileSdk = libs.versions.client.platform.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.client.platform.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

kotlin {
    jvm()
    androidTarget()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.client.network.ktor.core)
                implementation(libs.client.network.ktor.logging)
                implementation(libs.client.network.ktor.negotiation)
                implementation(libs.client.network.ktor.json)
                implementation(projects.sdk.common.serialization.kotlin)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.client.network.ktor.okhttp)
            }
        }
        jvmMain {
            dependencies {
                implementation(libs.client.network.ktor.cio)
            }
        }
    }
}

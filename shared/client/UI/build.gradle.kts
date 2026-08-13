plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
//                api(projects.sdk.client.ui.compose)
//                api(projects.sdk.client.ui.decompose)
//
//                api(projects.shared.common.core)

                implementation(projects.sdk.client.ui.compose)
                implementation(projects.sdk.client.ui.decompose)

                implementation(projects.shared.common.core)
            }
        }
    }
}
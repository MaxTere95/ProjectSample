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
                implementation(projects.sdk.client.ui.compose)
                implementation(projects.sdk.client.ui.decompose)
                api(projects.sdk.client.di.koin.modules.platform)

                api(projects.shared.client.di)
                implementation(projects.shared.client.components.root.core)
            }
        }
    }
}
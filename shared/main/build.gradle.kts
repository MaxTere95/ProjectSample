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
                implementation(projects.sdk.ui.compose)
                implementation(projects.sdk.ui.decompose)
                api(projects.sdk.di.koin.modules.platform)

                api(projects.shared.di)
                implementation(projects.shared.components.root.core)
            }
        }
    }
}
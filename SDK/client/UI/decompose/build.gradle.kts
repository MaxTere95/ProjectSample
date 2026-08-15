plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.client.arch.decompose)
                api(libs.client.arch.decompose.compose)
                api(libs.client.arch.essenty.lifecycle)

                implementation(projects.sdk.common.coroutines)
            }
        }
    }
}
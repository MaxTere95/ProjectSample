plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    compilerOptions {
        freeCompilerArgs.add("-Xexplicit-backing-fields")
    }

    sourceSets {
        commonMain {
            dependencies {
                api(projects.shared.client.components.main.core)
            }
        }
    }
}
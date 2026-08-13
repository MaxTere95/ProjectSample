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
                api(projects.shared.client.components.home.core)
                implementation(projects.shared.client.data.repository.core)
            }
        }
    }
}
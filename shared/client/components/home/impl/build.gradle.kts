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
                api(projects.shared.components.home.core)
                implementation(projects.shared.data.repository.core)
            }
        }
    }
}
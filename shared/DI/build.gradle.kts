plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.di.koin.core)

                implementation(projects.sdk.di.koin.modules.platform)
                implementation(projects.sdk.di.koin.modules.sqldelight)

                implementation(projects.shared.data.database.di.koin)
                implementation(projects.shared.data.repository.di.koin)
                implementation(projects.shared.components.root.di.koin)
                implementation(projects.shared.components.main.di.koin)
                implementation(projects.shared.components.home.di.koin)
            }
        }
    }
}
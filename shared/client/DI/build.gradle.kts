plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.common.di.koin.core)

                implementation(projects.sdk.client.di.koin.modules.platform)
                implementation(projects.sdk.client.di.koin.modules.sqldelight)
                implementation(projects.sdk.client.di.koin.modules.ktor)
                implementation(projects.sdk.client.di.koin.modules.settings)

                implementation(projects.shared.client.data.database.di.koin)
                implementation(projects.shared.client.data.repository.di.koin)
                implementation(projects.shared.client.components.root.di.koin)
                implementation(projects.shared.client.components.main.di.koin)
                implementation(projects.shared.client.components.home.di.koin)
            }
        }
    }
}
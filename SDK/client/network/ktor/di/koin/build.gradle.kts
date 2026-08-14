plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                // Подключаем базовый кор-DI
//                implementation(projects.sdk.common.di.koin.core)
                implementation(projects.sdk.client.di.koin.core)

                // Нам понадобится модуль сериализации, чтобы забрать оттуда Json
                implementation(projects.sdk.common.serialization.kotlin)

                // Подключаем наш новый сетевой модуль на Ktor
                implementation(projects.sdk.client.network.ktor.core)
            }
        }
    }
}

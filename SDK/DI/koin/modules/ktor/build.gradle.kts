plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                // Подключаем базовый кор-DI
                implementation(projects.sdk.di.koin.core)

                // Подключаем наш новый сетевой модуль на Ktor
                implementation(projects.sdk.network.ktor)

                // Нам понадобится модуль сериализации, чтобы забрать оттуда Json
                implementation(projects.sdk.serialization.kotlin)
            }
        }
    }
}

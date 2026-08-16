plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                // Прячем внешний Spring Web стартер внутрь SDK
                api(libs.server.network.spring.web)
            }
        }
    }
}

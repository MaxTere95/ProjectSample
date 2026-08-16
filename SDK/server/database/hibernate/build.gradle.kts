plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.server.db.spring.jpa)
                api(libs.server.db.driver.sqlite)
            }
        }
    }
}

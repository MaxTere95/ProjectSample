plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.server.db.exposed.core)
                api(libs.server.db.exposed.dao)
                api(libs.server.db.exposed.jdbc)
                api(libs.server.db.driver.sqlite)
            }
        }
    }
}

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.sqlDelight)
}

sqldelight {
    databases {
        create("AppDB") {
            packageName.set("ru.maxtere.upc.db")
        }
    }
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sdk.client.database.sqlDelight.core)
                implementation(projects.shared.common.core)
            }
        }
    }
}
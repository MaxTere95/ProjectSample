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
                api(projects.sdk.database.sqlDelight.core)

                implementation(projects.shared.common.logic)
            }
        }
    }
}
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

dependencies {
    implementation(projects.sdk.ui.compose)
    implementation(projects.shared.main)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
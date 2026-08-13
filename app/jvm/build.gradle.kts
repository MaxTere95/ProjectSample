plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

dependencies {
    implementation(projects.sdk.client.ui.compose)
    implementation(projects.sdk.client.platform.core)
    implementation(projects.shared.client.main)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
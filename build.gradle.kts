// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    `kotlin-dsl`

    // Общие плагины Kotlin
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.jvm) apply false

    // Клиентские плагины (Compose, Android, БД)
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.kmpLibrary) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.sqlDelight) apply false

    // Серверные плагины
    alias(libs.plugins.ktor) apply false
}

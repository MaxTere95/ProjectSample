enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ProjectSample"

includeProject()

//fun includeSDK() {
//    include(":SDK:platform:core")
//    include(":SDK:platform:di:koin")
//
//    include(":SDK:coroutines")
//
//    include(":SDK:DI:koin:core")
//    include(":SDK:DI:koin:modules:platform")
//    include(":SDK:DI:koin:modules:sqldelight")
//    include(":SDK:DI:koin:modules:ktor")
//    include(":SDK:DI:koin:modules:settings")
//
//    include(":SDK:serialization:kotlin")
//
//    include(":SDK:UI:compose")
//
//    include(":SDK:UI:decompose")
//
//    include(":SDK:database:sqlDelight:core")
//    include(":SDK:database:sqlDelight:impl")
//    include(":SDK:database:sqlDelight:di:koin")
//
//    include(":SDK:network:ktor:core")
//    include(":SDK:network:ktor:di:koin")
//
////    include(":SDK:network:retrofit")
////    include(":SDK:serialization:gson")
////
//    include(":SDK:datetime")
//
//    include(":SDK:settings:core")
//    include(":SDK:settings:di:koin")
//}

fun includeSDK() {
    // === COMMON ===
    include(":SDK:common:coroutines")
    include(":SDK:common:datetime")
    include(":SDK:common:serialization:kotlin")
    include(":SDK:common:DI:koin:core")

    // === CLIENT ===
    include(":SDK:client:platform:core")
    include(":SDK:client:platform:di:koin")

    include(":SDK:client:UI:compose")
    include(":SDK:client:UI:decompose")

    include(":SDK:client:database:sqlDelight:core")
    include(":SDK:client:database:sqlDelight:impl")
    include(":SDK:client:database:sqlDelight:di:koin")

    include(":SDK:client:network:ktor:core")
    include(":SDK:client:network:ktor:di:koin")
    include(":SDK:client:network:retrofit")

    include(":SDK:client:settings:core")
    include(":SDK:client:settings:di:koin")

    include(":SDK:client:DI:koin:modules:platform")
    include(":SDK:client:DI:koin:modules:sqldelight")
    include(":SDK:client:DI:koin:modules:ktor")
    include(":SDK:client:DI:koin:modules:settings")

    include(":SDK:client:serialization:gson")

    // === SERVER ===
    include(":SDK:server:network:ktor")
    include(":SDK:server:logs:logback")
}

fun includeServer() {
    include(":server:sample")
}

fun includeProject() {
    includeSDK()
    includeShared()
    includeApp()

    includeServer()
}

fun includeApp() {
    include(":app:android")
    include(":app:jvm")
}

fun includeShared() {
    includeUI()
    includeMain()
    includeDI()
    includeComponents()

    includeCommon()
    includeDatabase()
    includeRepository()
}

fun includeComponents() {
    includeRootComponent()
    includeMainComponent()
    includeHomeComponent()
}

fun includeMain() {
    include(":shared:client:main")
}

fun includeDI() {
    include(":shared:client:DI")
}

fun includeCommon() {
//    include(":shared:common:logic")
//    include(":shared:common:ui")
    include(":shared:common:core")
}

fun includeUI() {
    include(":shared:client:UI")
}

fun includeDatabase() {
    include(":shared:client:data:database:core")
    include(":shared:client:data:database:di:koin")
}

fun includeRepository() {
    include(":shared:client:data:repository:core")
    include(":shared:client:data:repository:impl")
    include(":shared:client:data:repository:di:koin")
}

fun includeRootComponent() {
    include(":shared:client:components:root:core")
    include(":shared:client:components:root:impl")
    include(":shared:client:components:root:di:koin")
}

fun includeMainComponent() {
    include(":shared:client:components:main:core")
    include(":shared:client:components:main:impl")
    include(":shared:client:components:main:di:koin")
}

fun includeHomeComponent() {
    include(":shared:client:components:home:core")
    include(":shared:client:components:home:impl")
    include(":shared:client:components:home:di:koin")
}

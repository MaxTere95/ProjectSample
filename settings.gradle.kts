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
}


fun includeTests() {
    include(":tests:jvmTest")
}

fun includeServer() {
    include(":server:sample")
}

fun includeProject() {
    includeSDK()
//    includeShared()
//    includeApp()

//    includeServer()
}

fun includeApp() {
    include(":app:android")
    include(":app:jvm")
}

fun includeShared() {
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
    include(":shared:main")
}

fun includeDI() {
    include(":shared:DI")
}

fun includeCommon() {
    include(":shared:common:logic")
    include(":shared:common:ui")
}

fun includeDatabase() {
    include(":shared:data:database:core")
    include(":shared:data:database:di:koin")
}

fun includeRepository() {
    include(":shared:data:repository:core")
    include(":shared:data:repository:impl")
    include(":shared:data:repository:di:koin")
}

fun includeRootComponent() {
    include(":shared:components:root:core")
    include(":shared:components:root:impl")
    include(":shared:components:root:di:koin")
}

fun includeMainComponent() {
    include(":shared:components:main:core")
    include(":shared:components:main:impl")
    include(":shared:components:main:di:koin")
}

fun includeHomeComponent() {
    include(":shared:components:home:core")
    include(":shared:components:home:impl")
    include(":shared:components:home:di:koin")
}

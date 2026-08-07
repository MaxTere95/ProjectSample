enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
//        google {
//            content {
//                includeGroupByRegex("com\\.android.*")
//                includeGroupByRegex("com\\.google.*")
//                includeGroupByRegex("androidx.*")
//            }
//
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
        google()
        mavenCentral()
        gradlePluginPortal()

//        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
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

fun includeSDK() {
    include(":SDK:platform:core")
    include(":SDK:platform:di:koin")

    include(":SDK:coroutines")

    include(":SDK:DI:koin:core")
    include(":SDK:DI:koin:modules:platform")
    include(":SDK:DI:koin:modules:sqldelight")

    include(":SDK:serialization:kotlin")

    include(":SDK:UI:compose")
    include(":SDK:UI:decompose")

//    Можно отключить в шаблоне
    include(":SDK:database:sqlDelight:core")
    include(":SDK:database:sqlDelight:impl")
    include(":SDK:database:sqlDelight:di:koin")
//    include(":SDK:network:retrofit")
//    include(":SDK:serialization:gson")
//
    include(":SDK:datetime")
//    include(":SDK:settings")
}

fun includeTests() {
    include(":tests:jvmTest")
}

fun includeServer() {
    include(":server:sample")
}

fun includeProject() {
    includeSDK()
    includeShared()
    includeApp()

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

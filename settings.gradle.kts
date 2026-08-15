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

//********************************************************************************+SDK
fun includeCommonSDK() {
    include(":SDK:common:coroutines")
    include(":SDK:common:datetime")
    include(":SDK:common:serialization:kotlin")
    include(":SDK:common:DI:koin:core")
}

fun includeClientSDK() {
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

    include(":SDK:client:DI:koin:core")
    include(":SDK:client:DI:koin:modules:platform")
    include(":SDK:client:DI:koin:modules:sqldelight")
    include(":SDK:client:DI:koin:modules:ktor")
    include(":SDK:client:DI:koin:modules:settings")

    include(":SDK:client:serialization:gson")
}

fun includeServerSDK() {
    include(":SDK:server:network:ktor")
    include(":SDK:server:logs:logback")
}
//********************************************************************************-SDK

fun includeProject() {
    includeCommonSDK()
    includeCommonShared()
    includeApp()
//    includeServer()
}

fun includeCommonShared() {
    include(":shared:common:core")
}

//********************************************************************************+Client
fun includeApp() {
    includeClientSDK()
//    includeClientShared()
//
//    include(":app:android")
//    include(":app:jvm")
}

fun includeClientShared(){
    includeDatabase()
    includeRepository()

    includeUI()
    includeComponents()

    includeDI()
    includeMain()
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

fun includeUI() {
    include(":shared:client:ui")
}

fun includeComponents() {
    includeRootComponent()
    includeMainComponent()
    includeHomeComponent()
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

fun includeDI() {
    include(":shared:client:DI")
}

fun includeMain() {
    include(":shared:client:main")
}
//********************************************************************************-Client
//********************************************************************************+Server

fun includeServer() {
    includeServerSDK()
    includeServerShared()

    include(":server:sample")
}

fun includeServerShared(){
    include(":shared:server:ktor")
}
//********************************************************************************-Server
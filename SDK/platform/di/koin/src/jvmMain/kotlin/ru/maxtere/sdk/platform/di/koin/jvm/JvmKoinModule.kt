package ru.maxtere.sdk.platform.di.koin.jvm

import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module
import ru.maxtere.sdk.platform.PlatformConfig

internal fun jvmKoinModule(platformConfig: PlatformConfig) = module {
    single<PlatformConfig> { platformConfig }
    single<ComponentContext> { platformConfig.defaultComponentContext }
}

fun jvmKoinModule() = jvmKoinModule(platformConfig = PlatformConfig())
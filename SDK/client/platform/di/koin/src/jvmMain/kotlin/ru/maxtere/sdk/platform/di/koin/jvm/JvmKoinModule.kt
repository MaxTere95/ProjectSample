package ru.maxtere.sdk.platform.di.koin.jvm

import ru.maxtere.sdk.settings.AppSettingsConfig
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module
import ru.maxtere.sdk.platform.PlatformConfig

fun jvmKoinModule(
    platformConfig: PlatformConfig = PlatformConfig()
) = module {
    single<PlatformConfig> { platformConfig }
    single<ComponentContext> { platformConfig.defaultComponentContext }
    single<AppSettingsConfig> { AppSettingsConfig() }
}
package ru.maxtere.sdk.platform.di.koin

import ru.maxtere.sdk.platform.PlatformConfig
import ru.maxtere.sdk.platform.di.koin.jvm.jvmKoinModule

actual fun platformKoinModule(platformConfig: PlatformConfig) =
    jvmKoinModule(platformConfig = platformConfig)
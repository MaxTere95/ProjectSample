package ru.maxtere.sdk.platform.di.koin

import ru.maxtere.sdk.platform.PlatformConfig
import ru.maxtere.sdk.platform.di.koin.android.androidKoinModule

actual fun platformKoinModule(platformConfig: PlatformConfig) =
    androidKoinModule(platformConfig = platformConfig)
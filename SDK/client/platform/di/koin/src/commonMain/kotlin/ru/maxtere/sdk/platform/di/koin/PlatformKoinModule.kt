package ru.maxtere.sdk.platform.di.koin

import org.koin.core.module.Module
import ru.maxtere.sdk.platform.PlatformConfig

expect fun platformKoinModule(platformConfig: PlatformConfig): Module
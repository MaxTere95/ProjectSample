package ru.maxtere.upc

import org.koin.core.module.Module
import ru.maxtere.sdk.di.koin.initKoin

fun initKoin(platformKoinModule: Module) = initKoin(
    modules = CommonModules.toList() + platformKoinModule
)

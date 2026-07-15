package ru.maxtere.sdk.di.koin

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(
    modules: List<Module>
): KoinApplication = startKoin {
    modules(modules = modules)
}
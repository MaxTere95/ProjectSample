package ru.maxtere.upc.main.component.di.koin

import org.koin.dsl.module
import ru.maxtere.upc.components.main.MainComponentFactory
import ru.maxtere.upc.components.main.MainComponentFactoryImpl

val mainKoinModule = module {
    single<MainComponentFactory> {
        MainComponentFactoryImpl(
            homeComponentFactory = get()
        )
    }
}
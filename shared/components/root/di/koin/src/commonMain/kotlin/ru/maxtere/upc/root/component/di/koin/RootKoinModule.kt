package ru.maxtere.upc.root.component.di.koin

import org.koin.dsl.module
import ru.maxtere.sdk.di.koin.getKoinInstance
import ru.maxtere.upc.components.root.RootComponent
import ru.maxtere.upc.components.root.RootComponentFactory
import ru.maxtere.upc.components.root.RootComponentFactoryImpl

val rootKoinModule = module {
    single<RootComponent> {
        getKoinInstance<RootComponentFactory>().create(
            context = get()
        )
    }

    single<RootComponentFactory> {
        RootComponentFactoryImpl(
            mainComponentFactory = get()
        )
    }
}
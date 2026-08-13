package ru.maxtere.upc.home.component.di.koin

import org.koin.dsl.module
import ru.maxtere.upc.components.docslist.DocsListComponentFactory
import ru.maxtere.upc.components.docslist.DocsListComponentFactoryImpl
import ru.maxtere.upc.components.editdoc.EditDocComponentFactory
import ru.maxtere.upc.components.editdoc.EditDocComponentFactoryImpl
import ru.maxtere.upc.components.home.HomeComponentFactory
import ru.maxtere.upc.components.home.HomeComponentFactoryImpl
import ru.maxtere.upc.components.readdoc.ReadDocComponentFactory
import ru.maxtere.upc.components.readdoc.ReadDocComponentFactoryImpl

val homeKoinModule = module {
    single<HomeComponentFactory> {
        HomeComponentFactoryImpl(
            repository = get(),
            docsListComponentFactory = get(),
            readDocComponentFactory = get(),
            editDocComponentFactory = get()
        )
    }

    single<DocsListComponentFactory> {
        DocsListComponentFactoryImpl()
    }

    single<ReadDocComponentFactory> {
        ReadDocComponentFactoryImpl()
    }

    single<EditDocComponentFactory> {
        EditDocComponentFactoryImpl()
    }
}
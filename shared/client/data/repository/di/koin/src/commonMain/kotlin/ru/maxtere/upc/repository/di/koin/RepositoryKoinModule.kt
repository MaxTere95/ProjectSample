package ru.maxtere.upc.repository.di.koin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module
import ru.maxtere.upc.repository.DocsRepository
import ru.maxtere.upc.repository.impl.DocsRepositoryImpl

val repositoryKoinModule = module {
    single<DocsRepository> {
        DocsRepositoryImpl(
            functionsQueries = get(),
            coroutineContext = Dispatchers.IO + SupervisorJob()
        )
    }
}
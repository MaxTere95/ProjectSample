package ru.maxtere.sdk.di.koin.modules.ktor

import org.koin.dsl.module
import ru.maxtere.sdk.network.ktor.createHttpClient

val ktorNetworkModule = module {
    single {
        createHttpClient(json = get())
    }
}
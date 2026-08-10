package ru.maxtere.sdk.di.koin.modules.ktor

import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import ru.maxtere.sdk.network.ktor.createHttpClient

val ktorKoinModule = module {
    single<HttpClient> {
        createHttpClient(json = get())
    }

    single<Json> {
        Json {
            ignoreUnknownKeys = true // Игнорировать новые поля от API, которых нет в наших DTO
            prettyPrint = true       // Красивый отступ при логировании JSON строк
            isLenient = true         // Смягчить парсинг (разрешить кавычки, спецсимволы и т.д.)
        }
    }
}
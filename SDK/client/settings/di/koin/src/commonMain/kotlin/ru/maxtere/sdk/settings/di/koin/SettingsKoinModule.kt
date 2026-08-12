package ru.maxtere.sdk.settings.di.koin

import com.russhwolf.settings.Settings
import org.koin.dsl.module
import ru.maxtere.sdk.settings.AppSettings

val settingsKoinModule = module {
    // Предполагается, что AppSettingsConfig уже будет объявлен в графе зависимостей
    // на уровне конкретной платформы (Android/JVM)
    single<AppSettings> { AppSettings(appSettingsConfig = get()) }

    // Для удобства регистрируем сам интерфейс Settings из библиотеки,
    // чтобы репозитории могли инжектить его напрямую без обертки
    single<Settings> { get<AppSettings>().settings }
}

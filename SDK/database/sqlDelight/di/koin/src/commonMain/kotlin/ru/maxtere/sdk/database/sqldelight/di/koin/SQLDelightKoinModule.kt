package ru.maxtere.sdk.database.sqldelight.di.koin

import org.koin.dsl.module
import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK
import ru.maxtere.sdk.database.sqldelight.impl.SQLDelightConfiguration
import ru.maxtere.sdk.database.sqldelight.impl.SQLDelightSDK
import ru.maxtere.sdk.database.sqldelight.impl.toSQLDelightConfiguration
import ru.maxtere.sdk.di.koin.getKoinInstance
import ru.maxtere.sdk.platform.PlatformConfig

val sqlDelightKoinModule = module {
    single<SQLDelightSDK> {
        SQLDelightSDK(
            sqlDelightConfiguration = get()
        )
    }

    single<SQLDelightConfiguration> {
        getKoinInstance<PlatformConfig>().toSQLDelightConfiguration()
    }
}
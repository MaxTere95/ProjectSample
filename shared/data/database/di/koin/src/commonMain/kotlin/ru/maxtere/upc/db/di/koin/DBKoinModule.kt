package ru.maxtere.upc.db.di.koin

import org.koin.dsl.module
import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK
import ru.maxtere.sdk.di.koin.getKoinInstance
import ru.maxtere.upc.db.AppDB
import ru.maxtere.upc.db.AppDBCreator
import ru.maxtere.upc.db.FunctionsQueries

val dbKoinModule = module {
    single<AppDB> {
        getKoinInstance<SQLDelightSDK>().createDatabase(
            dbCreator = AppDBCreator()
        )
    }

    single<FunctionsQueries> {
        getKoinInstance<AppDB>().functionsQueries
    }
}
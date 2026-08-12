package ru.maxtere.upc

import ru.maxtere.sdk.database.sqldelight.di.koin.sqlDelightKoinModule
import ru.maxtere.sdk.di.koin.modules.ktor.ktorKoinModule
import ru.maxtere.sdk.settings.di.koin.settingsKoinModule
import ru.maxtere.upc.db.di.koin.dbKoinModule
import ru.maxtere.upc.home.component.di.koin.homeKoinModule
import ru.maxtere.upc.main.component.di.koin.mainKoinModule
import ru.maxtere.upc.repository.di.koin.repositoryKoinModule
import ru.maxtere.upc.root.component.di.koin.rootKoinModule

object CommonModules {
    fun toList() = listOf(
        settingsKoinModule,
        sqlDelightKoinModule,
        ktorKoinModule,
        dbKoinModule,
        repositoryKoinModule,
        homeKoinModule,
        mainKoinModule,
        rootKoinModule
    )
}

package ru.maxtere.upc.db

import app.cash.sqldelight.ColumnAdapter
import kotlinx.datetime.LocalDate
import ru.maxtere.sdk.database.sqldelight.DBCreator
import ru.maxtere.sdk.database.sqldelight.DBDriverCreator

class AppDBCreator(
    override val nameDB: String = "AppDB"
) : DBCreator<AppDB> {
    override fun createDatabase(dbDriverCreator: DBDriverCreator): AppDB {
        return AppDB(
            driver = dbDriverCreator.createDriver(
                nameDB = nameDB,
                sqlSchema = AppDB.Schema
            ),
            DocDBOAdapter = DocDBO.Adapter(LocalDateAdapter)
        )
    }

    private object LocalDateAdapter : ColumnAdapter<LocalDate, String> {
        override fun decode(databaseValue: String) = LocalDate.parse(databaseValue)
        override fun encode(value: LocalDate) = value.toString()
    }
}

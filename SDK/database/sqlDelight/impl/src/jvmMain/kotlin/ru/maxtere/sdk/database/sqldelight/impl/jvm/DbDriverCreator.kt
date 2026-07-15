package ru.maxtere.sdk.database.sqldelight.impl.jvm

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import ru.maxtere.sdk.database.sqldelight.DBDriverCreator

fun DBDriverCreator(): DBDriverCreator = DBDriverCreatorForJVM()

internal class DBDriverCreatorForJVM : DBDriverCreator {
    override fun createDriver(
        nameDB: String,
        sqlSchema: SqlSchema<QueryResult.Value<Unit>>
    ): SqlDriver {
//        val dbFile = File("db", "$nameDB.db")
//        println(dbFile.absolutePath)

        val driver: SqlDriver = JdbcSqliteDriver(
//            url = "jdbc:sqlite:${dbFile.absolutePath}",
            url = "jdbc:sqlite:$nameDB.db",
            schema = sqlSchema
        )

        return driver
    }
}
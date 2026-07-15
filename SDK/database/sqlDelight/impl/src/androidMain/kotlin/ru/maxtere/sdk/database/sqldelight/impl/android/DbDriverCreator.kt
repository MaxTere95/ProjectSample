package ru.maxtere.sdk.database.sqldelight.impl.android

import android.content.Context
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.maxtere.sdk.database.sqldelight.DBDriverCreator

fun DBDriverCreator(
    androidContext: Context
): DBDriverCreator = DBDriverCreatorForAndroid(
    androidContext = androidContext
)

class DBDriverCreatorForAndroid(private val androidContext: Context) : DBDriverCreator {
    override fun createDriver(
        nameDB: String,
        sqlSchema: SqlSchema<QueryResult.Value<Unit>>
    ): SqlDriver = AndroidSqliteDriver(
        name = "$nameDB.db",
        schema = sqlSchema,
        context = androidContext
    )
}
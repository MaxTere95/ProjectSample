package ru.maxtere.sdk.database.sqldelight

import app.cash.sqldelight.TransacterBase

abstract class SQLDelightSDK {
    abstract val dbDriverCreator: DBDriverCreator
    fun <T : TransacterBase> createDatabase(dbCreator: DBCreator<T>): T {
        return dbCreator.createDatabase(dbDriverCreator = dbDriverCreator)
    }
}
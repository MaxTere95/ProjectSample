package ru.maxtere.sdk.database.sqldelight

import app.cash.sqldelight.TransacterBase

interface DBCreator<T : TransacterBase> {
    val nameDB: String
    fun createDatabase(dbDriverCreator: DBDriverCreator): T
}
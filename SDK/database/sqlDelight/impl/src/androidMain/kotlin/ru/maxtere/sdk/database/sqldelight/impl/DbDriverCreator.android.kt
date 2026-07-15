package ru.maxtere.sdk.database.sqldelight.impl

import ru.maxtere.sdk.database.sqldelight.DBDriverCreator
import ru.maxtere.sdk.database.sqldelight.impl.android.DBDriverCreator

actual fun DBDriverCreator(
    sqlDelightConfiguration: SQLDelightConfiguration
): DBDriverCreator = DBDriverCreator(
    androidContext = sqlDelightConfiguration.androidContext
)

package ru.maxtere.sdk.database.sqldelight.impl

import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK
import ru.maxtere.sdk.database.sqldelight.impl.android.SQLDelightSDK

actual fun SQLDelightSDK(
    sqlDelightConfiguration: SQLDelightConfiguration
): SQLDelightSDK = SQLDelightSDK(
    androidContext = sqlDelightConfiguration.androidContext
)

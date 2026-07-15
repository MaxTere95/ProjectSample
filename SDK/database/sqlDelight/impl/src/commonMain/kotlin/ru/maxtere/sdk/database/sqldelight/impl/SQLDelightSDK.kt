package ru.maxtere.sdk.database.sqldelight.impl

import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK
import ru.maxtere.sdk.platform.PlatformConfig

expect fun SQLDelightSDK(sqlDelightConfiguration: SQLDelightConfiguration): SQLDelightSDK

fun SQLDelightSDK(platformConfig: PlatformConfig) = SQLDelightSDK(
    sqlDelightConfiguration = platformConfig.toSQLDelightConfiguration()
)
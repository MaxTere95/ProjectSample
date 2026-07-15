package ru.maxtere.sdk.database.sqldelight.impl

import ru.maxtere.sdk.platform.PlatformConfig

actual fun PlatformConfig.toSQLDelightConfiguration(): SQLDelightConfiguration =
    SQLDelightConfiguration()

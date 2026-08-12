package ru.maxtere.sdk.database.sqldelight.impl

import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK
import ru.maxtere.sdk.database.sqldelight.impl.jvm.SQLDelightSDKForJVM

actual fun SQLDelightSDK(
    sqlDelightConfiguration: SQLDelightConfiguration
): SQLDelightSDK = SQLDelightSDKForJVM()

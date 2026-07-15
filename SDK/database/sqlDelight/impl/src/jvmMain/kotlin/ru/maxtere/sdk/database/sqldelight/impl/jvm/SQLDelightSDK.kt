package ru.maxtere.sdk.database.sqldelight.impl.jvm

import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK


class SQLDelightSDKForJVM : SQLDelightSDK() {
    override val dbDriverCreator = DBDriverCreator()
}

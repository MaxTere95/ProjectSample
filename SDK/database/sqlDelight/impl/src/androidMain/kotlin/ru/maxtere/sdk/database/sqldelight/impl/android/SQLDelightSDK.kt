package ru.maxtere.sdk.database.sqldelight.impl.android

import android.content.Context
import ru.maxtere.sdk.database.sqldelight.SQLDelightSDK

fun SQLDelightSDK(
    androidContext: Context
): SQLDelightSDK {
    return SQLDelightSDKForAndroid(androidContext = androidContext)
}

internal class SQLDelightSDKForAndroid(androidContext: Context) : SQLDelightSDK() {
    override val dbDriverCreator = DBDriverCreator(androidContext = androidContext)
}
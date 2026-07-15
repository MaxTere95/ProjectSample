package ru.maxtere.sdk.settings

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

actual class AppSettings actual constructor(
    appSettingsConfig: AppSettingsConfig
) {
    actual val settings: Settings = SharedPreferencesSettings(
        appSettingsConfig.androidContext.getSharedPreferences(
            "AppSettings",
            Context.MODE_PRIVATE
        )
    )
}
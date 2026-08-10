package ru.maxtere.sdk.settings

import com.russhwolf.settings.Settings

expect class AppSettings constructor(
    appSettingsConfig: AppSettingsConfig
) {
    val settings: Settings
}
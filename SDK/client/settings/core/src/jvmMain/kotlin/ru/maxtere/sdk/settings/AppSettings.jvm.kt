package ru.maxtere.sdk.settings

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

actual class AppSettings actual constructor(
    appSettingsConfig: AppSettingsConfig
) {
    actual val settings: Settings = PreferencesSettings(Preferences.userRoot())
}
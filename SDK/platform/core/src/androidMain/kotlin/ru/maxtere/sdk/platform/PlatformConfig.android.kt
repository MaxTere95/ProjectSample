package ru.maxtere.sdk.platform

import android.content.Context
import androidx.activity.ComponentActivity
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext

actual class PlatformConfig(
//    actual val defaultComponentContext: ComponentContext,
    val defaultComponentContext: ComponentContext,
    val androidContext: Context
)

fun ComponentActivity.androidPlatformConfig() = PlatformConfig(
    androidContext = this,
    defaultComponentContext = defaultComponentContext()
)
package ru.maxtere.sdk.platform

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

actual class PlatformConfig(
//    actual val defaultComponentContext: ComponentContext
    val defaultComponentContext: ComponentContext = DefaultComponentContext(
        lifecycle = LifecycleRegistry()
    )
)

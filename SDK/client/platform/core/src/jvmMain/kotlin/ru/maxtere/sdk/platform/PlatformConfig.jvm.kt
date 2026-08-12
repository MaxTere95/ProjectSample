package ru.maxtere.sdk.platform

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop

actual class PlatformConfig {
    // 1. Создаем внутренний реестр жизненного цикла
    private val lifecycleRegistry = LifecycleRegistry()

    // 2. Создаем контекст Decompose
    val defaultComponentContext: ComponentContext = DefaultComponentContext(
        lifecycle = lifecycleRegistry
    )

    // 3. Метод для запуска навигации
    fun start() {
        lifecycleRegistry.resume()
    }

    // 4. Метод для безопасной остановки корутин и очистки памяти
    fun stop() {
        lifecycleRegistry.stop()
    }
}

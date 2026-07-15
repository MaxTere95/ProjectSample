package ru.maxtere.sdk.ui.decompose

import com.arkivanov.decompose.ComponentContext

interface DecomposeComponentFactory<T : DecomposeComponent> {
    fun create(context: ComponentContext): T
}
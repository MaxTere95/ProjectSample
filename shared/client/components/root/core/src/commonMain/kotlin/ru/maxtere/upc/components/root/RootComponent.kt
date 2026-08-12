package ru.maxtere.upc.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.maxtere.sdk.ui.decompose.DecomposeComponent
import ru.maxtere.upc.components.main.MainComponent

abstract class RootComponent(context: ComponentContext) :
    DecomposeComponent(context = context) {
    abstract val stack: Value<ChildStack<Config, Child>>

    @Serializable
    sealed interface Config {
        @Serializable
        data object Main : Config
    }

    sealed interface Child {
        class Main(val component: MainComponent) : Child
    }
}
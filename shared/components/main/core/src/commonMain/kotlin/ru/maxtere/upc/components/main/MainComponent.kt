package ru.maxtere.upc.components.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable
import ru.maxtere.sdk.ui.decompose.DecomposeComponent
import ru.maxtere.upc.components.home.HomeComponent
import ru.maxtere.upc.components.main.bottombar.AppTab

abstract class MainComponent(context: ComponentContext) :
    DecomposeComponent(context = context) {
    abstract val stack: Value<ChildStack<Config, Child>>
    abstract val state: StateFlow<State>

    abstract fun onClickTab(appTab: AppTab)

    @Serializable
    data class State(
        val selectedTab: AppTab
    ) {
        companion object {
            val DEFAULT = State(
                selectedTab = AppTab.Home
            )
        }
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Home : Config
    }

    sealed interface Child {
        class Home(val component: HomeComponent) : Child
    }
}

package ru.maxtere.upc.components.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.maxtere.upc.components.home.HomeComponentFactory
import ru.maxtere.upc.components.main.bottombar.AppTab

internal class MainComponentImpl(
    context: ComponentContext,
    private val homeComponentFactory: HomeComponentFactory
) : MainComponent(context = context) {
    private val navigation = StackNavigation<Config>()
//    private val _state = MutableStateFlow(State.DEFAULT)
//    override val state = _state.asStateFlow()

    override val state: StateFlow<State>
        field = MutableStateFlow(State.DEFAULT)


    override val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        childFactory = ::createStack,
        initialConfiguration = Config.Home,
        handleBackButton = true
    )

    override fun onClickTab(appTab: AppTab) {

//        _state.value = state.value.copy(
        state.value = state.value.copy(
            selectedTab = appTab
        )

//        navigation.replaceCurrent()
        navigation.bringToFront(appTab.toConfig())

    }

    private fun createStack(
        config: Config,
        context: ComponentContext
    ) = when (config) {
        is Config.Home -> Child.Home(
            component = homeComponentFactory.create(context = context)
        )
    }
}

private fun AppTab.toConfig(): MainComponent.Config = when (this) {
    AppTab.Home -> MainComponent.Config.Home
}
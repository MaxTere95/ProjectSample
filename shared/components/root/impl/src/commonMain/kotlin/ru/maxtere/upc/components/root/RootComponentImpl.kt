package ru.maxtere.upc.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import ru.maxtere.upc.components.main.MainComponentFactory

internal class RootComponentImpl(
    context: ComponentContext,
    private val mainComponentFactory: MainComponentFactory
) : RootComponent(context = context) {
    private val navigation = StackNavigation<Config>()
    override val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        childFactory = ::createStack,
        initialConfiguration = Config.Main,
        handleBackButton = true
    )

    private fun createStack(
        config: Config,
        context: ComponentContext
    ) = when (config) {
        is Config.Main -> Child.Main(
            component = mainComponentFactory.create(context)
        )
    }
}
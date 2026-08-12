package ru.maxtere.upc.components.root

import com.arkivanov.decompose.ComponentContext
import ru.maxtere.upc.components.main.MainComponentFactory

class RootComponentFactoryImpl(
    private val mainComponentFactory: MainComponentFactory
) : RootComponentFactory {
    override fun create(context: ComponentContext) = RootComponentImpl(
        context = context,
        mainComponentFactory = mainComponentFactory
    ) as RootComponent
}
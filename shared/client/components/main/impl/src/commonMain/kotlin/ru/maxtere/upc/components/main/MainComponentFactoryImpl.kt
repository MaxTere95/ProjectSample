package ru.maxtere.upc.components.main

import com.arkivanov.decompose.ComponentContext
import ru.maxtere.upc.components.home.HomeComponentFactory

class MainComponentFactoryImpl(
    private val homeComponentFactory: HomeComponentFactory
) : MainComponentFactory {
    override fun create(context: ComponentContext) = MainComponentImpl(
        context = context,
        homeComponentFactory = homeComponentFactory
    ) as MainComponent
}
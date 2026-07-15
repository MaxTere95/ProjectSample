package ru.maxtere.upc.components.readdoc

import com.arkivanov.decompose.ComponentContext


class ReadDocComponentFactoryImpl : ReadDocComponentFactory {
    override fun create(
        context: ComponentContext,
        onClickListener: ReadDocOnClickListener
    ): ReadDocComponent = ReadDocComponentImpl(
        context = context,
        onClickListener = onClickListener
    ) as ReadDocComponent
}

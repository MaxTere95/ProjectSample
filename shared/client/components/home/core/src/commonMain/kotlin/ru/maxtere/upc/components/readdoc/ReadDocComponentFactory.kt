package ru.maxtere.upc.components.readdoc

import com.arkivanov.decompose.ComponentContext

interface ReadDocComponentFactory {
    fun create(
        context: ComponentContext,
        onClickListener: ReadDocOnClickListener
    ): ReadDocComponent
}

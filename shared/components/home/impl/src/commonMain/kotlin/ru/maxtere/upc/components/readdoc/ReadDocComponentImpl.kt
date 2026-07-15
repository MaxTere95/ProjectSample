package ru.maxtere.upc.components.readdoc

import com.arkivanov.decompose.ComponentContext

internal class ReadDocComponentImpl(
    context: ComponentContext,
    onClickListener: ReadDocOnClickListener
) : ReadDocComponent(
    context = context,
    onClickListener = onClickListener
)

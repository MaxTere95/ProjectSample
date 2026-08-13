package ru.maxtere.upc.components.readdoc

import com.arkivanov.decompose.ComponentContext

abstract class ReadDocComponent(
    context: ComponentContext,
    onClickListener: ReadDocOnClickListener
) : ReadDocOnClickListener by onClickListener

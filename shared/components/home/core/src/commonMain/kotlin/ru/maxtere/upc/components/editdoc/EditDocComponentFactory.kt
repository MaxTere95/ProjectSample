package ru.maxtere.upc.components.editdoc

import com.arkivanov.decompose.ComponentContext

interface EditDocComponentFactory {
    fun create(
        context: ComponentContext,
        onClickListener: EditDocOnClickListener
    ): EditDocComponent
}

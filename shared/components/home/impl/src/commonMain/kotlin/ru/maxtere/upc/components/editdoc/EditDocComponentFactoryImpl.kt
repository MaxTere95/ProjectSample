package ru.maxtere.upc.components.editdoc

import com.arkivanov.decompose.ComponentContext


class EditDocComponentFactoryImpl : EditDocComponentFactory {
    override fun create(
        context: ComponentContext,
        onClickListener: EditDocOnClickListener
    ) = EditDocComponentImpl(
        context = context,
        onClickListener = onClickListener
    ) as EditDocComponent
}

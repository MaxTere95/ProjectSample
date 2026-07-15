package ru.maxtere.upc.components.editdoc

import com.arkivanov.decompose.ComponentContext

internal class EditDocComponentImpl(
    context: ComponentContext,
    onClickListener: EditDocOnClickListener
) : EditDocComponent(
    context = context,
    onClickListener = onClickListener
)


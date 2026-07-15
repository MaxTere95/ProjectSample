package ru.maxtere.upc.components.editdoc

import com.arkivanov.decompose.ComponentContext

abstract class EditDocComponent(
    context: ComponentContext,
    onClickListener: EditDocOnClickListener
) : EditDocOnClickListener by onClickListener

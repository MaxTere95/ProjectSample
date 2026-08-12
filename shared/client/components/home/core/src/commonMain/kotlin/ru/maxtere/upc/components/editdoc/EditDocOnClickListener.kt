package ru.maxtere.upc.components.editdoc

import ru.maxtere.upc.models.Doc

interface EditDocOnClickListener {
    fun onClickSaveDoc(doc: Doc)
}

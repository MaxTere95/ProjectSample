package ru.maxtere.upc.components.docslist

import ru.maxtere.upc.models.Doc

interface DocsListOnClickListener {
    fun onClickAddDoc()
    fun onClickDoc(doc: Doc)
    fun onClickDeleteDoc(doc: Doc)
}

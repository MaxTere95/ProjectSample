package ru.maxtere.upc.components.readdoc

import ru.maxtere.upc.models.Doc

interface ReadDocOnClickListener {
    fun onClickEditDoc(doc: Doc)
}

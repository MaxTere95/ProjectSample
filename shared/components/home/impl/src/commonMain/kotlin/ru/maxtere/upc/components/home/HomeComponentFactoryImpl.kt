package ru.maxtere.upc.components.home

import com.arkivanov.decompose.ComponentContext
import ru.maxtere.upc.components.docslist.DocsListComponentFactory
import ru.maxtere.upc.components.editdoc.EditDocComponentFactory
import ru.maxtere.upc.components.readdoc.ReadDocComponentFactory
import ru.maxtere.upc.repository.DocsRepository


class HomeComponentFactoryImpl(
    private val repository: DocsRepository,
    private val docsListComponentFactory: DocsListComponentFactory,
    private val readDocComponentFactory: ReadDocComponentFactory,
    private val editDocComponentFactory: EditDocComponentFactory
) : HomeComponentFactory {
    override fun create(context: ComponentContext) = HomeComponentImpl(
        context = context,
        repository = repository,
        docsListComponentFactory = docsListComponentFactory,
        readDocComponentFactory = readDocComponentFactory,
        editDocComponentFactory = editDocComponentFactory
    ) as HomeComponent
}
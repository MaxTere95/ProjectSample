package ru.maxtere.upc.components.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import ru.maxtere.upc.components.docslist.DocsListComponentFactory
import ru.maxtere.upc.components.docslist.DocsListOnClickListener
import ru.maxtere.upc.components.editdoc.EditDocComponentFactory
import ru.maxtere.upc.components.editdoc.EditDocOnClickListener
import ru.maxtere.upc.components.readdoc.ReadDocComponentFactory
import ru.maxtere.upc.components.readdoc.ReadDocOnClickListener
import ru.maxtere.upc.models.Doc
import ru.maxtere.upc.repository.DocsRepository

internal class HomeComponentImpl(
    context: ComponentContext,
    private val repository: DocsRepository,
    private val docsListComponentFactory: DocsListComponentFactory,
    private val readDocComponentFactory: ReadDocComponentFactory,
    private val editDocComponentFactory: EditDocComponentFactory
) : HomeComponent(context = context),
    DocsListOnClickListener, ReadDocOnClickListener, EditDocOnClickListener {
    private val navigation = StackNavigation<Config>()
    override val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        childFactory = ::createStack,
        initialConfiguration = Config.DocsList,
        handleBackButton = true
    )

//    init {
//        repository.saveDoc(
//            doc = Doc(
//                id = 0,
//                name = "test 1",
//                dateOfDoc = LocalDate.parse("2026-01-01"),
//                tableRows = listOf()
//            )
//        )
//    }

    private fun createStack(
        config: Config,
        context: ComponentContext
    ) = when (config) {
        is Config.DocsList -> Child.DocsList(
            component = docsListComponentFactory.create(
                context = context,
                docsListFlow = repository.getDocsFlow(),
                onClickListener = this
            )
        )

        is Config.ReadDoc -> Child.ReadDoc(
            component = readDocComponentFactory.create(
                context = context,
                onClickListener = this
            )
        )

        is Config.EditDoc -> Child.EditDoc(
            component = editDocComponentFactory.create(
                context = context,
                onClickListener = this
            )
        )
    }

    override fun onClickDoc(doc: Doc) = navigation.replaceCurrent(
        configuration = Config.ReadDoc
    )

    override fun onClickAddDoc() = editDoc(
        doc = Doc.NEW
    )

    override fun onClickEditDoc(doc: Doc) = editDoc(
        doc = doc
    )

    override fun onClickDeleteDoc(doc: Doc) = repository.deleteDoc(doc = doc)

    override fun onClickSaveDoc(doc: Doc) = repository.saveDoc(doc = doc)

    private fun editDoc(doc: Doc) = navigation.replaceCurrent(
        configuration = Config.EditDoc
    )
}

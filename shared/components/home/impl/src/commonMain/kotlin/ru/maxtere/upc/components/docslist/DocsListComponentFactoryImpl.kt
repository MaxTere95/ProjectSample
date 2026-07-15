package ru.maxtere.upc.components.docslist

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import ru.maxtere.upc.models.Doc

class DocsListComponentFactoryImpl : DocsListComponentFactory {
    override fun create(
        context: ComponentContext,
        docsListFlow: Flow<List<Doc>>,
        onClickListener: DocsListOnClickListener
    ) = DocsListComponentImpl(
        context = context,
        docsListFlow = docsListFlow,
        onClickListener = onClickListener
    ) as DocsListComponent
}

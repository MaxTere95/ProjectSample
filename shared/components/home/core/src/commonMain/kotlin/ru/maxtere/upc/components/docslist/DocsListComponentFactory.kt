package ru.maxtere.upc.components.docslist

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import ru.maxtere.upc.models.Doc

interface DocsListComponentFactory {
    fun create(
        context: ComponentContext,
        docsListFlow: Flow<List<Doc>>,
        onClickListener: DocsListOnClickListener
    ): DocsListComponent
}

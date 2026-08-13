package ru.maxtere.upc.components.docslist.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.maxtere.upc.components.docslist.DocsListComponent
import ru.maxtere.upc.components.docslist.compose.views.DocsListView

@Composable
fun DocsListScreen(component: DocsListComponent) {
    val state by component.state.collectAsState()

    DocsListView(
        list = state.docsList,
        onClickAddNew = component::onClickAddDoc,
        onClickItem = component::onClickDoc,
        onClickDelete = component::onClickDeleteDoc
    )
}
package ru.maxtere.upc.components.docslist.compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.maxtere.upc.models.Doc

@Composable
fun DocsListView(
    list: List<Doc>,
    onClickAddNew: (() -> Unit)? = null,
    onClickItem: ((Doc) -> Unit)? = null,
    onClickDelete: ((Doc) -> Unit)? = null
) {
    LazyColumn {
        items(list.size) {
            DocItemView(
                doc = list[it],
                onClickItem = onClickItem,
                onClickDelete = onClickDelete
            )
        }
    }

    if (onClickAddNew != null) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            AddNewButtonView(
                onClickAddNew = onClickAddNew,
                modifier = Modifier.background(color = Color.Green).size(40.dp)
            )
        }
    }
}

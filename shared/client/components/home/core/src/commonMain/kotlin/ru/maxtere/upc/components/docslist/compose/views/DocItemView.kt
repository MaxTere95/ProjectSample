package ru.maxtere.upc.components.docslist.compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.maxtere.upc.models.Doc

@Composable
fun DocItemView(
    doc: Doc,
    onClickItem: ((Doc) -> Unit)? = null,
    onClickDelete: ((Doc) -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color.Green)
            .clickable {
                if (onClickItem != null) onClickItem(doc)
            }
    ) {
        Text(text = "${doc.id} ${doc.dateOfDoc} ${doc.name}")
    }
}
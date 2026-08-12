package ru.maxtere.upc.components.docslist.compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddNewButtonView(
    onClickAddNew: (() -> Unit),
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClickAddNew,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            modifier = Modifier
                .background(color = Color.Green)
                .size(40.dp)
        )
    }
}
package ru.maxtere.upc.components.home.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.maxtere.upc.components.docslist.compose.screens.DocsListScreen
import ru.maxtere.upc.components.editdoc.compose.screens.EditDocScreen
import ru.maxtere.upc.components.home.HomeComponent
import ru.maxtere.upc.components.home.HomeComponent.Child
import ru.maxtere.upc.components.readdoc.compose.screens.ReadDocScreen

@Composable
fun HomeScreen(component: HomeComponent) {
    val stack by component.stack.subscribeAsState()

    Children(
        stack = stack,
        modifier = Modifier,
        animation = null
    ) { child ->
        HomeScreen(instance = child.instance)
    }
}

@Composable
fun HomeScreen(instance: Child) {
    when (instance) {
        is Child.DocsList -> DocsListScreen(component = instance.component)
        is Child.ReadDoc -> ReadDocScreen(component = instance.component)
        is Child.EditDoc -> EditDocScreen(component = instance.component)
    }
}

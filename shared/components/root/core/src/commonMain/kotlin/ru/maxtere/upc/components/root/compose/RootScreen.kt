package ru.maxtere.upc.components.root.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.maxtere.upc.components.main.compose.MainScreen
import ru.maxtere.upc.components.root.RootComponent

@Composable
fun RootScreen(component: RootComponent) {
    val stack by component.stack.subscribeAsState()

    Children(
        stack = stack,
        modifier = Modifier,
        animation = null
    ) { child ->
        RootScreen(instance = child.instance)
    }
}

@Composable
fun RootScreen(instance: RootComponent.Child) {
    when (instance) {
        is RootComponent.Child.Main -> MainScreen(component = instance.component)
    }
}

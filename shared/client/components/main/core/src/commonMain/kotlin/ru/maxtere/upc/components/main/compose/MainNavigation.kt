package ru.maxtere.upc.components.main.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import ru.maxtere.upc.components.home.compose.screens.HomeScreen
import ru.maxtere.upc.components.main.MainComponent

@Composable
fun MainNavigation(stack: ChildStack<*, MainComponent.Child>) {
    Children(
        stack = stack,
        modifier = Modifier,
        animation = null
    ) { child ->
        MainNavigation(instance = child.instance)
    }
}

@Composable
fun MainNavigation(instance: MainComponent.Child) {
    when (instance) {
        is MainComponent.Child.Home -> HomeScreen(component = instance.component)
    }
}
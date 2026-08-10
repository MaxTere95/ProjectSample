package ru.maxtere.upc

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import ru.maxtere.upc.components.root.RootComponent
import ru.maxtere.upc.components.root.compose.RootScreen

@Composable
fun App() {
//    RootScreen(
//        component = getKoinInstance<RootComponent>()
//    )
    RootScreen(
        component = koinInject<RootComponent>()
    )
}
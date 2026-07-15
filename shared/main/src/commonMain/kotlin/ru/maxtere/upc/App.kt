package ru.maxtere.upc

import androidx.compose.runtime.Composable
import ru.maxtere.sdk.di.koin.getKoinInstance
import ru.maxtere.upc.components.root.RootComponent
import ru.maxtere.upc.components.root.compose.RootScreen

@Composable
fun App() {
    RootScreen(
        component = getKoinInstance<RootComponent>()
    )
}
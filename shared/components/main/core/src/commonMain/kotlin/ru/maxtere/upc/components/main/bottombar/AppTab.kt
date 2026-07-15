package ru.maxtere.upc.components.main.bottombar

sealed interface AppTab {
    data object Home : AppTab
}
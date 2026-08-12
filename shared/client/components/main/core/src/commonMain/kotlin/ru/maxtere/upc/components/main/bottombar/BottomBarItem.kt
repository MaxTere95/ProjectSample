package ru.maxtere.upc.components.main.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

data class BottomBarItem(
    val title: StringResource,
    val appTab: AppTab,
    val icon: ImageVector
) {
    companion object {
        fun getItems() = listOf<BottomBarItem>(
//            BottomBarItem(
//                title = Res.string.Home,
//                appTab = AppTab.Home,
//                icon = Icons.Rounded.Home
//            )
        )
    }
}
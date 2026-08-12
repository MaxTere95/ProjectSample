package ru.maxtere.upc.components.main.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ru.maxtere.upc.components.main.bottombar.AppTab
import ru.maxtere.upc.components.main.bottombar.BottomBarItem

@Composable
fun MainBottomBar(
    selectedTab: AppTab,
    clickOnTab: (AppTab) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
//            .align(Alignment.BottomCenter)
//            .background(
//                AppThemeProvider.colors.surface,
//                shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)
//            )
    ) {
        BottomBarItem.getItems().forEach { item ->
            BottomBarItemView(item, item.appTab == selectedTab) {
                clickOnTab(item.appTab)
            }
        }
    }
}

//
@Composable
fun BottomBarItemView(
    bottomBarItem: BottomBarItem,
    isSelected: Boolean,
    clickOnTab: () -> Unit
) {

//    val foreground =
//        if (isSelected) AppThemeProvider.colors.accent else AppThemeProvider.colors.onSurface


    val foreground =
        if (isSelected) Color(0xFFAF9363) else Color(0xFF99A6B5)
    Column(
        modifier = Modifier
//            .weight(1f)
            .padding(4.dp).clickable { clickOnTab() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = bottomBarItem.icon,
            contentDescription = stringResource(bottomBarItem.title),
//            contentDescription = bottomBarItem.title.key,
            modifier = Modifier.size(22.dp),
            colorFilter = ColorFilter.tint(foreground)
        )
        Text(
            stringResource(bottomBarItem.title),
//            bottomBarItem.title.key,
            color = foreground,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
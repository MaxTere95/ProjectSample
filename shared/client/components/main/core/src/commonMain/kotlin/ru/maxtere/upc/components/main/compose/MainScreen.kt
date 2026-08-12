package ru.maxtere.upc.components.main.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.maxtere.upc.components.main.MainComponent

@Composable
fun MainScreen(component: MainComponent) {
    val stack by component.stack.subscribeAsState()
    val state by component.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
//                .fillMaxWidth()
//                .fillMaxHeight(0.91f)
        ) {
            MainNavigation(stack = stack)
        }

//        if (BottomBarItem.getItems().size > 1) {
//            MainBottomBar(
//                selectedTab = state.selectedTab,
//                clickOnTab = component::onClickTab
//            )
//        }
    }
}
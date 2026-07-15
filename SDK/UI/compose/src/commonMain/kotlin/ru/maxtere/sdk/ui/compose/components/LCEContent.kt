package ru.maxtere.sdk.ui.compose.components

import androidx.compose.runtime.Composable
import ru.maxtere.sdk.ui.compose.errors.AppError
import ru.maxtere.sdk.ui.compose.screens.LoadingScreen
import ru.maxtere.sdk.ui.compose.screens.NetworkErrorScreen
import ru.maxtere.sdk.ui.compose.states.LCEState

@Composable
fun <T> LCEContent(
    state: LCEState<T>,
    onClickTryAgain: () -> Unit,
    content: @Composable (T) -> Unit
) {
    when (state) {
        is LCEState.Loading -> {
            LoadingScreen()
        }
        is LCEState.Error -> {
            when (state.error) {
                is AppError.Network -> NetworkErrorScreen(onClickTryAgain = onClickTryAgain)
                // Здесь в шаблоне можно расширить обработку под Server или Unknown ошибки
                else -> NetworkErrorScreen(onClickTryAgain = onClickTryAgain)
            }
        }
        is LCEState.Content -> {
            content(state.data)
        }
    }
}

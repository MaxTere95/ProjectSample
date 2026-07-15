package ru.maxtere.sdk.ui.compose.states

import ru.maxtere.sdk.ui.compose.errors.AppError

sealed interface LCEState<out T> {
    data object Loading : LCEState<Nothing>
    data class Content<out T>(val data: T) : LCEState<T>
    data class Error(val error: AppError) : LCEState<Nothing>
}
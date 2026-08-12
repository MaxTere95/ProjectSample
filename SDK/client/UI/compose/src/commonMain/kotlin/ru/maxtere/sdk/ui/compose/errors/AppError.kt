package ru.maxtere.sdk.ui.compose.errors

sealed interface AppError {
    data object Network : AppError                      // Ошибки отсутствия интернета / таймауты
    data class Server(val code: Int) : AppError         // 500, 404 и другие ответы бэкенда
    data class Unknown(val message: String?) : AppError // Непредвиденные исключения
}

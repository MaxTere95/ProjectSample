import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ru.maxtere.sdk.platform.di.koin.jvm.jvmKoinModule
import ru.maxtere.upc.App
import ru.maxtere.upc.initKoin

fun main() {
    initKoin(
        platformKoinModule = jvmKoinModule()
    )

    application {
        Window(
            title = "UPC App",
            onCloseRequest = ::exitApplication,
            state = WindowState(
                size = DpSize(400.dp, 800.dp)
            ),
            resizable = false
        ) {
            App()
        }
    }
}
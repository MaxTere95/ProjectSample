package ru.maxtere.upc.app.android

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.maxtere.sdk.platform.di.koin.android.androidKoinModule
import ru.maxtere.upc.App
import ru.maxtere.upc.initKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        initKoin(platformKoinModule = androidKoinModule())

        setContent {
            App()
        }
    }
}

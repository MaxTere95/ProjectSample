package ru.maxtere.sdk.platform.di.koin.android

import android.content.Context
import androidx.activity.ComponentActivity
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module
import ru.maxtere.sdk.platform.PlatformConfig
import ru.maxtere.sdk.platform.androidPlatformConfig

internal fun androidKoinModule(platformConfig: PlatformConfig) = module {
    single<Context> { platformConfig.androidContext }
    single<ComponentContext> { platformConfig.defaultComponentContext }
    single<PlatformConfig> { platformConfig }
}

fun ComponentActivity.androidKoinModule() =
    androidKoinModule(platformConfig = androidPlatformConfig())

//fun ComponentActivity.defaultPlatformKoinModuleTest(){
//    PlatformConfig(androidContext = this, defaultComponentContext = this.defaultComponentContext())
//}
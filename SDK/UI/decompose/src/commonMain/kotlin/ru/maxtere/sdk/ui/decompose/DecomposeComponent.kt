package ru.maxtere.sdk.ui.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class DecomposeComponent(
    context: ComponentContext
) : ComponentContext by context, Component {
    protected val componentScope: CoroutineScope = CoroutineScope(
        context = SupervisorJob()
    ).apply {
        lifecycle.doOnDestroy { cancel() }
    }
}

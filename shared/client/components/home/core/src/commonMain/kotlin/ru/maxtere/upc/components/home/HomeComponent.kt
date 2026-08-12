package ru.maxtere.upc.components.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.maxtere.sdk.ui.decompose.DecomposeComponent
import ru.maxtere.upc.components.docslist.DocsListComponent
import ru.maxtere.upc.components.editdoc.EditDocComponent
import ru.maxtere.upc.components.readdoc.ReadDocComponent

abstract class HomeComponent(
    context: ComponentContext
) : DecomposeComponent(
    context = context
) {
    abstract val stack: Value<ChildStack<Config, Child>>

    @Serializable
    sealed interface Config {
        @Serializable
        data object DocsList : Config

        @Serializable
        data object ReadDoc : Config

        @Serializable
        data object EditDoc : Config
    }

    sealed interface Child {
        class DocsList(val component: DocsListComponent) : Child
        class ReadDoc(val component: ReadDocComponent) : Child
        class EditDoc(val component: EditDocComponent) : Child
    }
}

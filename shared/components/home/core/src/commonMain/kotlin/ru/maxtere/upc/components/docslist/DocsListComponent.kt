package ru.maxtere.upc.components.docslist

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import ru.maxtere.sdk.ui.decompose.DecomposeComponent
import ru.maxtere.upc.models.Doc

abstract class DocsListComponent(
    context: ComponentContext,
    onClickListener: DocsListOnClickListener
) : DecomposeComponent(
    context = context
), DocsListOnClickListener by onClickListener {
    abstract val state: StateFlow<State>

    @Serializable
    data class State(
        val docsList: List<Doc>
    ) {
        companion object {
            val NONE = State(
                docsList = emptyList()
            )

            val SAMPLE = State(
                docsList = listOf(
                    Doc(
                        id = 1,
                        name = "test 1",
                        dateOfDoc = LocalDate.parse("2026-01-01"),
                        tableRows = listOf()
                    ),
                    Doc(
                        id = 2,
                        name = "test 2",
                        dateOfDoc = LocalDate.parse("2026-01-31"),
                        tableRows = listOf()
                    ),
                    Doc(
                        id = 3,
                        name = "test 3",
                        dateOfDoc = LocalDate.parse("1995-12-07"),
                        tableRows = listOf()
                    )
                )
            )
        }
    }
}

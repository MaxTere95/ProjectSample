package ru.maxtere.upc.components.docslist

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import ru.maxtere.upc.models.Doc

internal class DocsListComponentImpl(
    context: ComponentContext,
    docsListFlow: Flow<List<Doc>>,
    onClickListener: DocsListOnClickListener
) : DocsListComponent(
    context = context,
    onClickListener = onClickListener
) {
//    private val _state = MutableStateFlow(value = State.NONE)
//    override val state = _state.asStateFlow()

    override val state: StateFlow<State>
        field = MutableStateFlow(State.NONE)

    init {
        activateDocsListFlow(flow = docsListFlow)
    }

    private fun activateDocsListFlow(flow: Flow<List<Doc>>) {
        flow.onEach { newList ->
//            _state.update { state ->
            state.update { state ->
                state.copy(
                    docsList = newList
                )
            }
        }.launchIn(componentScope)
    }
}

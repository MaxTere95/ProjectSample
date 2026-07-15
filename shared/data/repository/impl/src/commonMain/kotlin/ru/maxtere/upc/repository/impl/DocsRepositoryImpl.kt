package ru.maxtere.upc.repository.impl

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.maxtere.upc.db.DocDBO
import ru.maxtere.upc.db.FunctionsQueries
import ru.maxtere.upc.mappers.toDBO
import ru.maxtere.upc.mappers.toDocByID
import ru.maxtere.upc.mappers.toDocRow
import ru.maxtere.upc.models.Doc
import ru.maxtere.upc.repository.DocsRepository
import kotlin.coroutines.CoroutineContext

class DocsRepositoryImpl(
    private val functionsQueries: FunctionsQueries,
    private val coroutineContext: CoroutineContext
) : DocsRepository {

    override fun getDocs(): List<Doc> = functionsQueries.selectAllDocs()
        .executeAsList()
        .map {
            it.toDocByID()
        }

    override fun getDocsFlow(): Flow<List<Doc>> = functionsQueries.selectAllDocs()
        .asFlow()
        .mapToList(context = coroutineContext)
        .map { list ->
            list.map {
                it.toDocByID()
            }
        }

    override fun saveDoc(doc: Doc) = functionsQueries.transaction {
        val docForSaving = docForSaving(doc = doc)
        functionsQueries.saveDoc(
            DocDBO = docForSaving.toDBO()
        )
        functionsQueries.deleteRowsByDocID(idDoc = docForSaving.id)

        var currentID = 1L
        docForSaving.tableRows.forEach {
            functionsQueries.saveRow(
                DocRowDBO = it.toDBO()
                    .copy(id = currentID)
            )
            currentID++
        }
    }

    override fun deleteDoc(doc: Doc) = functionsQueries.transaction {
        functionsQueries.deleteDocByID(
            id = doc.id
        )
        functionsQueries.deleteRowsByDocID(
            idDoc = doc.id
        )
    }

    private fun DocDBO.toDocByID(): Doc = toDocByID(
        getRows = { idDoc: Long ->
            functionsQueries.selectRowsByDocID(idDoc = idDoc)
                .executeAsList()
                .map {
                    it.toDocRow()
                }
        }
    )

    private fun docForSaving(doc: Doc): Doc {
        if (doc.id != 0L) {
            return doc
        }
        val newID: Long = 1 + (
                functionsQueries.getMaxIDDoc()
                    .executeAsOne()
                    .maxID ?: 0
                )
        return doc.copy(id = newID)
    }
}
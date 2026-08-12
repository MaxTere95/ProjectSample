package ru.maxtere.upc.repository

import kotlinx.coroutines.flow.Flow
import ru.maxtere.upc.models.Doc

interface DocsRepository {
    fun getDocs(): List<Doc>
    fun getDocsFlow(): Flow<List<Doc>>
    fun saveDoc(doc: Doc)
    fun deleteDoc(doc: Doc)
}
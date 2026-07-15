package ru.maxtere.upc.mappers

import ru.maxtere.upc.db.DocDBO
import ru.maxtere.upc.db.DocRowDBO
import ru.maxtere.upc.models.Doc
import ru.maxtere.upc.models.DocRow

fun DocDBO.toDoc(
    tableRows: List<DocRow>
): Doc = Doc(
    id = id,
    name = name,
    dateOfDoc = dateOfDoc,
    tableRows = tableRows
)

fun DocDBO.toDoc(
    getRows: () -> List<DocRow>
): Doc = toDoc(
    tableRows = getRows()
)

fun DocDBO.toDocByID(
    getRows: (idDoc: Long) -> List<DocRow>,
    idDoc: Long = id
): Doc = toDoc(
    getRows = {
        getRows(idDoc)
    }
)

fun DocRowDBO.toDocRow(): DocRow = DocRow(
    id = id,
    idDoc = idDoc,
    costType = costType,
    costQuantity = costQuantity,
    costPrice = costPrice,
    costSum = costSum,
    meterReadingStart = meterReadingStart,
    meterReadingEnd = meterReadingEnd
)

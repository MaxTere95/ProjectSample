package ru.maxtere.upc.mappers

import ru.maxtere.upc.db.DocDBO
import ru.maxtere.upc.db.DocRowDBO
import ru.maxtere.upc.models.Doc
import ru.maxtere.upc.models.DocRow

fun Doc.toDBO(): DocDBO = DocDBO(
    id = id,
    name = name,
    dateOfDoc = dateOfDoc
)

fun DocRow.toDBO(): DocRowDBO = DocRowDBO(
    id = id,
    idDoc = idDoc,
    costType = costType,
    costTittle = costTittle,
    costQuantity = costQuantity,
    costPrice = costPrice,
    costSum = costSum,
    meterReadingStart = meterReadingStart,
    meterReadingEnd = meterReadingEnd
)

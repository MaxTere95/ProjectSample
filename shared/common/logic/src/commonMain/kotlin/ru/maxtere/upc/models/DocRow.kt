package ru.maxtere.upc.models

import kotlinx.serialization.Serializable

@Serializable
data class DocRow(
    val id: Long,
    val idDoc: Long,
//    val costType: String,
    val costType: UtilityType,
    val costTittle: String,
    val costQuantity: Double,
    val costPrice: Double,
    val costSum: Double,
    val meterReadingStart: Double,
    val meterReadingEnd: Double
){
    companion object {
        // Удобная фабричная функция для создания строки с автоматическим вычислением расхода и суммы
        fun createWithCalculations(
            id: Long,
            idDoc: Long,
            type: UtilityType,
            readingStart: Double,
            readingEnd: Double,
            price: Double
        ): DocRow {
            // Вычисляем расход. Если конечное показание меньше начального (ошибка ввода), расход равен 0
            val quantity = if (readingEnd >= readingStart) readingEnd - readingStart else 0.0
            val sum = quantity * price

            return DocRow(
                id = id,
                idDoc = idDoc,
                costType = type,
                costTittle = type.displayName,
                costQuantity = quantity,
                costPrice = price,
                costSum = sum,
                meterReadingStart = readingStart,
                meterReadingEnd = readingEnd
            )
        }
    }
}
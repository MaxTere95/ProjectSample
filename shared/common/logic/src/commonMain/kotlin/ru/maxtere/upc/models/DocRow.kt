package ru.maxtere.upc.models

import kotlinx.serialization.Serializable

@Serializable
data class DocRow(
    val id: Long,
    val idDoc: Long,
    val costType: String,
    val costTittle: String,
    val costQuantity: Double,
    val costPrice: Double,
    val costSum: Double,
    val meterReadingStart: Double,
    val meterReadingEnd: Double
)
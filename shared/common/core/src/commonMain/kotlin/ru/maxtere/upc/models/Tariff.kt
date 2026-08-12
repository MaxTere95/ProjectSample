package ru.maxtere.upc.models

import kotlinx.serialization.Serializable

@Serializable
data class Tariff(
    val type: String,
    val price: Double
)
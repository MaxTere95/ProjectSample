package ru.maxtere.upc.models

import kotlinx.serialization.Serializable

@Serializable
data class Tarif(
    val type: String,
    val price: Double
)
package ru.maxtere.upc.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Doc(
    val id: Long,
    val name: String,
    val dateOfDoc: LocalDate,
    val tableRows: List<DocRow>
) {
    // Автоматический подсчёт общей суммы по всем счётчикам за месяц
    val totalAmount: Double
        get() = tableRows.sumOf { it.costSum }

    companion object {
        val NEW = Doc(
            id = 0,
            name = "",
            dateOfDoc = LocalDate.parse("2020-01-01"),
            tableRows = listOf()
        )
    }
}

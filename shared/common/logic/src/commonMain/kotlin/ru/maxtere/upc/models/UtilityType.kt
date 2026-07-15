package ru.maxtere.upc.models

import kotlinx.serialization.Serializable

@Serializable
enum class UtilityType(val idName: String, val displayName: String, val unit: String) {
    WATER_COLD("water_cold", "Холодное водоснабжение", "м³"),
    WATER_HOT("water_hot", "Горячее водоснабжение", "м³"),
    WATER_DRAINAGE("water_drainage", "Водоотведение", "м³"),
    ELECTRICITY("electricity", "Электричество", "кВт·ч"),
    HEATING("heating", "Отопление", "Гкал"),
    GAS("gas", "Газ", "м³")
}

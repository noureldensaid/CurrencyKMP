package org.coinz.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import org.coinz.domain.models.LatestExchangeRateModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Entity(tableName = "LatestExchangeRateEntity")
data class LatestExchangeRateEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val lastUpdatedAt: String,
    val currencies: List<Map<String, Double>>
)


fun LatestExchangeRateEntity.toModel() =
    LatestExchangeRateModel(
        lastUpdatedAt = this.lastUpdatedAt,
        currencies = this.currencies.flatMap { it.entries }.associate {
            it.key to org.coinz.domain.models.CurrencyModel(it.key, it.value)
        }
    )


class CurrencyConverter {
    @TypeConverter
    fun fromCurrencyList(currencies: List<Map<String, Double>>): String {
        return Json.encodeToString(currencies)
    }

    @TypeConverter
    fun toCurrencyList(currencyString: String): List<Map<String, Double>> {
        return Json.decodeFromString(currencyString)
    }
}
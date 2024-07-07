package data.remote.dto

import domain.models.CurrencyModel
import domain.models.LatestExchangeRateModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LatestExchangeRateDto(
    val meta: Meta,
    val data: Map<String, Currency>
)

@Serializable
data class Meta(
    @SerialName("last_updated_at")
    val lastUpdatedAt: String
)

@Serializable
data class Currency(
    val code: String,
    val value: Double
)

fun LatestExchangeRateDto.toLatestExchangeRateModel() = LatestExchangeRateModel(
    lastUpdatedAt = meta.lastUpdatedAt,
    currencies = data.mapValues { CurrencyModel(it.value.code, it.value.value) }
)
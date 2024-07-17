package org.coinz.data.remote.dto

import org.coinz.data.local.entity.LatestExchangeRateEntity
import org.coinz.domain.models.CurrencyModel
import org.coinz.domain.models.LatestExchangeRateModel
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

fun LatestExchangeRateDto.toModel() = LatestExchangeRateModel(
    lastUpdatedAt = meta.lastUpdatedAt,
    currencies = data.mapValues { CurrencyModel(it.value.code, it.value.value) }
)

fun LatestExchangeRateDto.toEntity() = LatestExchangeRateEntity(
    lastUpdatedAt = meta.lastUpdatedAt,
    currencies = data.entries.map { mapOf(it.key to it.value.value) }
)
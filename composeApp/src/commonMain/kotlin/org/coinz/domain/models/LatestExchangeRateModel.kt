package org.coinz.domain.models

data class LatestExchangeRateModel(
    val lastUpdatedAt: String,
    val currencies: Map<String, CurrencyModel>
)

data class CurrencyModel(
    val code: String,
    val value: Double
)
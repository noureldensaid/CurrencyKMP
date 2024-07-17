package org.coinz.domain.repository

import org.coinz.domain.models.LatestExchangeRateModel
import org.coinz.util.Error
import org.coinz.util.Result

interface Repository {
    suspend fun getLatestExchangeRates(): Result<LatestExchangeRateModel, Error>
}
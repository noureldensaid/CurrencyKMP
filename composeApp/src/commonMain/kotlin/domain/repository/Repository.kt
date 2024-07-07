package domain.repository

import common.RequestState
import domain.models.LatestExchangeRateModel

interface Repository {
    suspend fun getLatestExchangeRates(): RequestState<LatestExchangeRateModel>
}
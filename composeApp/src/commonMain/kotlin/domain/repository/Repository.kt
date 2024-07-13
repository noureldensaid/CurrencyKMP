package domain.repository

import domain.models.LatestExchangeRateModel
import util.Error
import util.NetworkError
import util.Result

interface Repository {
    suspend fun getLatestExchangeRates(): Result<LatestExchangeRateModel, Error>
}
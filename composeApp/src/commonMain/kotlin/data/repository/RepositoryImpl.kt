package data.repository

import util.SafeApiCall
import data.remote.ApiService
import data.remote.dto.LatestExchangeRateDto
import data.remote.dto.toLatestExchangeRateModel
import domain.models.LatestExchangeRateModel
import domain.repository.Repository
import io.ktor.client.call.body
import kotlinx.serialization.json.Json
import util.Error
import util.NetworkError
import util.Result

class RepositoryImpl(
    private val apiService: ApiService
) : Repository, SafeApiCall {
    override suspend fun getLatestExchangeRates() = safeApiCall {
        val apiRequest = apiService.getLatestExchangeRates()
        val response = Json.decodeFromString<LatestExchangeRateDto>(apiRequest.body())
        response.toLatestExchangeRateModel()
    }
}


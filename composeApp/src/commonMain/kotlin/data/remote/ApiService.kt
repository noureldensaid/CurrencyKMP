package data.remote

import data.remote.dto.LatestExchangeRateDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import util.Constants.END_POINT
import util.safeApiCall

class ApiService(
    private val httpClient: HttpClient
) {
    suspend fun getLatestExchangeRates() = safeApiCall<LatestExchangeRateDto> {
        httpClient.get(END_POINT)
    }
}
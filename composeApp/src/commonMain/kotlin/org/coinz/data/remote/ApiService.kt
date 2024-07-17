package org.coinz.data.remote

import org.coinz.data.remote.dto.LatestExchangeRateDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import org.coinz.util.Constants.END_POINT
import org.coinz.util.safeApiCall

class ApiService(
    private val httpClient: HttpClient
) {
    suspend fun getLatestExchangeRates() = safeApiCall<LatestExchangeRateDto> {
        httpClient.get(END_POINT)
    }
}
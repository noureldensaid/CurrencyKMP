package data.remote

import common.Constants.ENDPOINT
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(
    private val httpClient: HttpClient
) {
    suspend fun getLatestExchangeRates() = httpClient.get(ENDPOINT)

}
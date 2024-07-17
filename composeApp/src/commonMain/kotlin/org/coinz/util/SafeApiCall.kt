package org.coinz.util

import coil3.network.HttpException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import okio.IOException

suspend inline fun <reified T> safeApiCall(crossinline apiCall: suspend () -> HttpResponse): Result<T, NetworkError> {
    return withContext(Dispatchers.IO) {
        try {
            val response = apiCall.invoke()
            val statusCode = response.status.value

            when (statusCode) {
                in 200..299 -> {
                    val result = response.body<T>()
                    Result.Success(result)
                }

                401 -> Result.Error(NetworkError.UNAUTHORIZED)
                409 -> Result.Error(NetworkError.CONFLICT)
                408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
                413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
                in 500..511 -> Result.Error(NetworkError.SERVER_ERROR)
                else -> Result.Error(NetworkError.UNKNOWN)
            }
        } catch (e: UnresolvedAddressException) {
            Result.Error(NetworkError.NO_INTERNET)
        } catch (e: IOException) {
            Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.SERIALIZATION)
        } catch (e: HttpException) {
            Result.Error(NetworkError.SERVER_ERROR)
        } catch (e: Exception) {
            Result.Error(NetworkError.UNKNOWN)
        }
    }
}


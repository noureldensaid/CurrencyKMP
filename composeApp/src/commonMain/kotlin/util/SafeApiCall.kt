package util

import coil3.network.HttpException
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import okio.IOException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Result<T, Error> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Loading
                Result.Success(apiCall.invoke())
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
}



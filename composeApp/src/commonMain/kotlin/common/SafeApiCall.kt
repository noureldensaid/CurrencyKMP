package common

import coil3.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import okio.IOException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): RequestState<T> {
        return withContext(Dispatchers.IO) {
            try {
                RequestState.Loading
                RequestState.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> {
                        RequestState.NoInternetError()
                    }
                    is HttpException -> {
                        val errorMessage = throwable.message ?: "Unknown error"
                        RequestState.Error(errorMessage)
                    }
                    else -> {
                        RequestState.Error(
                            throwable.message ?: "Unknown error"
                        )
                    }
                }
            }
        }
    }
}

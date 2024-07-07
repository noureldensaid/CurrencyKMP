package common


sealed class RequestState<out T> {
    data object Idle : RequestState<Nothing>()
    data object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val error: String) : RequestState<Nothing>()
    data class NoInternetError(val message: String = "No internet connection") :
        RequestState<Nothing>()

    fun isLoading() = this is Loading
    fun isError() = this is Error || this is NoInternetError
    fun isSuccess() = this is Success
    fun getSuccessData(): T? {
        return (this as? Success)?.data
    }

    fun getErrorMessage(): String? {
        return when (this) {
            is Error -> error
            is NoInternetError -> message
            else -> null
        }
    }
}

package org.coinz.util

typealias EmptyResult<E> = Result<Unit, E>
sealed interface Result<out D, out E: Error> {
    data object Idle: Result<Nothing, Nothing>
    data object Loading: Result<Nothing, Nothing>
    data class Success<out D>(val data: D): Result<D, Nothing>
    data class Error<out E: org.coinz.util.Error>(val error: E): Result<Nothing, E>
}

inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when(this) {
        is Result.Idle -> Result.Idle
        is Result.Loading -> Result.Loading
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <T, E: Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {  }
}

inline fun <T, E: Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when(this) {
        is Result.Idle, is Result.Loading -> this
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}
inline fun <T, E: Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when(this) {
        is Result.Idle, is Result.Loading -> this
        is Result.Error -> {
            action(error)
            this
        }
        is Result.Success -> this
    }
}

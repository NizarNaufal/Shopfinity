package id.devnzr.domain.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector

sealed class ResultState<T>(
    val data: T? = null,
    val message: String = "",
    val code: Int = 0
) {
    class Success<T>(data: T) : ResultState<T>(data)

    class Loading<T>(previous: T? = null) : ResultState<T>(previous)

    class Idle<T>(previous: T? = null) : ResultState<T>(previous)

    class Error<T>(
        code: Int,
        message: String,
        previous: T? = null,
    ) :
        ResultState<T>(previous, message, code)
}

fun <T> ResultState<T>.success(): Boolean = this is ResultState.Success

fun <T> ResultState<T>.loading(): Boolean = this is ResultState.Loading

fun <T> ResultState<T>.idle(): Boolean = this is ResultState.Idle

fun <T> ResultState<T>.error(): Boolean = this is ResultState.Error

@JvmName("mapResultState")
fun <T, R> ResultState<T>.map(transform: (T) -> R): ResultState<R> {
    return when (this) {
        is ResultState.Success -> ResultState.Success(transform(data!!))
        is ResultState.Loading -> ResultState.Loading(data?.let { transform(it) })
        is ResultState.Idle -> ResultState.Idle(data?.let { transform(it) })
        is ResultState.Error -> ResultState.Error(code, message, data?.let { transform(it) })
    }
}

suspend fun <T> FlowCollector<ResultState<T>>.neutralize(
    value: ResultState<T>,
    previous: T? = null,
    delay: Long = 0
) {
    emit(value)

    delay(delay)

    emit(ResultState.Idle(previous = previous))
}
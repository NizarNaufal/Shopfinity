package id.devnzr.domain.usecase

import id.devnzr.domain.toResultStateError
import id.devnzr.domain.utils.ResultState
import id.devnzr.domain.utils.neutralize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object UseCaseDelegate {
    fun <T> neutralizeResultFlow(
        previous: T? = null,
        delay: Long = 1000L,
        errorDelay: Long = 4000L,
        block: (suspend () -> ResultState<T>)
    ): Flow<ResultState<T>> = flow {
        try {
            emit(ResultState.Loading(previous = previous))

            val response = block()

            neutralize(
                value = response,
                previous = response.data,
                delay = delay
            )
        } catch (e: Throwable) {
            neutralize(
                value = e.toResultStateError(),
                previous = previous,
                delay = errorDelay
            )
        }
    }
}

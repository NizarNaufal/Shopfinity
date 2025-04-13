package id.devnzr.domain

import id.devnzr.domain.utils.ResultState
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

suspend fun <R> Throwable.toResultStateError(): ResultState.Error<R> {
    return when (this) {
        is UnknownHostException -> {
            ResultState.Error(
                code = ErrorCode.UNKNOWN_HOST,
                message = message ?: "Host tidak dikenali",
            )
        }

        is HttpException -> {
            ResultState.Error(
                code = ErrorCode.CLIENT_TIMEOUT,
                message = message ?: "Request Timeout caused by your internet connection",
            )
        }

        is IOException -> {
            ResultState.Error(
                code = ErrorCode.NO_CONNECTION,
                message = message ?: "Something went wrong with your internet connection",
            )
        }

        else -> {
            ResultState.Error(
                code = ErrorCode.UNKNOWN_ERROR,
                message = "Error tidak diketahui",
            )
        }
    }
}

object ErrorCode {
    const val UNKNOWN_HOST = 1001
    const val CLIENT_TIMEOUT = 1002
    const val NO_CONNECTION = 1003
    const val UNKNOWN_ERROR = 1000
}
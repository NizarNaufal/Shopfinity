package id.devnzr.data.utils

import android.annotation.SuppressLint
import java.io.IOException

/**
 * A custom exception to represent various Retrofit-related issues.
 */
@SuppressLint("NewApi")
class RetrofitException private constructor(
    val code: Int? = null,
    override val message: String? = null,
    override val cause: Throwable? = null
) : IOException(message, cause) {

    companion object {
        const val NO_CONNECTION = -1
        const val TIMEOUT = -2
        const val UNKNOWN = -99

        fun noConnection(cause: Throwable? = null): RetrofitException {
            return RetrofitException(
                code = NO_CONNECTION,
                message = "Tidak ada koneksi internet",
                cause = cause
            )
        }

        fun timeout(cause: Throwable? = null): RetrofitException {
            return RetrofitException(
                code = TIMEOUT,
                message = "Permintaan waktu habis (timeout)",
                cause = cause
            )
        }

        fun unknown(cause: Throwable? = null): RetrofitException {
            return RetrofitException(
                code = UNKNOWN,
                message = "Terjadi kesalahan yang tidak diketahui",
                cause = cause
            )
        }

        fun httpError(code: Int, message: String, cause: Throwable? = null): RetrofitException {
            return RetrofitException(code = code, message = message, cause = cause)
        }
    }
}

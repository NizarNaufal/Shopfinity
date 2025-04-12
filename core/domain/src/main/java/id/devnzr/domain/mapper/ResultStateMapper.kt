package id.devnzr.domain.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.devnzr.data.entities.BaseDataSourceApi
import id.devnzr.domain.utils.ResultState
import id.devnzr.data.utils.RetrofitException
import id.devnzr.data.utils.RetrofitException.Companion.NO_CONNECTION
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException

fun <R> responseErrorToResultStateError(
    error: Throwable
): ResultState.Error<R> {
    when (error) {
        is HttpException -> {
            val data = getResponseFromThrowableAsList(error)
            val code = data.code ?: error.code()
            val message = data.message ?: "Maaf, Terjadi gangguan pada server [$code]"
            return ResultState.Error(code = code, message = message)
        }

        is RetrofitException -> {
            val message = when (error.code) {
                NO_CONNECTION -> "Tidak ada koneksi internet"
                else -> "Terjadi gangguan pada aplikasi [00${error.code}]"
            }

            return ResultState.Error(
                code = error.code!!, message = message
            )
        }

        else -> {
            return ResultState.Error(
                code = 0,
                message = "Sorry, ${error.localizedMessage}",
            )
        }
    }

}

private fun getResponseFromThrowableAsList(throwable: HttpException): BaseDataSourceApi<List<String>> {
    val type = object : TypeToken<BaseDataSourceApi<List<String>>>() {}.type
    val typeString = object : TypeToken<BaseDataSourceApi<String>>() {}.type
    val errorBody = throwable.response()?.errorBody()?.string()
    var errorResponse: BaseDataSourceApi<List<String>>? = null
    var errorResponseString: BaseDataSourceApi<String>? = null

    return try {
        errorBody?.let {
            errorResponse = Gson().fromJson(it.toResponseBody().charStream(), type)
        }
        errorResponse ?: BaseDataSourceApi(
            success = false,
            data = listOf("null"),
            "Terjadi gangguan pada server",
            0,
        )

    } catch (error: Exception) {
        try {
            errorBody?.let {
                errorResponseString = Gson().fromJson(it.toResponseBody().charStream(), typeString)
            }
            BaseDataSourceApi(
                success = errorResponseString?.success ?: false,
                data = listOf(errorResponseString?.data.toString()),
                message = errorResponseString?.message ?: "Terjadi gangguan pada servers",
                code = errorResponseString?.code ?: 0,
            )
        } catch (error: Exception) {
            BaseDataSourceApi(
                success = false,
                data = listOf(throwable.message.toString(), error.message.toString()),
                message = "${throwable.message()} [${throwable.code()}]",
                code = 0,
            )
        }

    }
}
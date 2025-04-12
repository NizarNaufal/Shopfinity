package id.devnzr.data.utils

sealed class ResultState<T>(
    val data: T? = null,
    val message: String = "",
    val code: Int = 0
) {
    class Success<T>(data: T) : ResultState<T>(data)

    class Loading<T> : ResultState<T>()

    class HideLoading<T> : ResultState<T>()

    class Error<T>(code: Int, message: String, data: T? = null) :
        ResultState<T>(data, message, code)
}
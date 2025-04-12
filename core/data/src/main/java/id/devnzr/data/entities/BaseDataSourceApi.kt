package id.devnzr.data.entities

import com.google.gson.annotations.SerializedName

data class BaseDataSourceApi<T>(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("data")
    val data: T?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("code")
    val code: Int?
)

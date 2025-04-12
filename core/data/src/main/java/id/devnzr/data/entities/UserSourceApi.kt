package id.devnzr.data.entities

import com.google.gson.annotations.SerializedName

data class UserSourceApi(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?,
)
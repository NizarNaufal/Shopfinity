package id.devnzr.data.models

import com.google.gson.annotations.SerializedName

data class Carts(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("userId")
    val userId: String?,
    @SerializedName("products")
    val products: List<Products>
)

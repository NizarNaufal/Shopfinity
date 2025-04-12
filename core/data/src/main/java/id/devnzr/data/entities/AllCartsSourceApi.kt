package id.devnzr.data.entities

import com.google.gson.annotations.SerializedName

data class AllCartsSourceApi(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("userId")
    val userId: String?,
    @SerializedName("products")
    val products: List<AllProductsSourceApi>
)
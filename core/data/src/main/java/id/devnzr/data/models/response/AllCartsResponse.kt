package id.devnzr.data.models.response

import com.google.gson.annotations.SerializedName

data class AllCartsResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("userId")
    val userId: String?,
    @SerializedName("products")
    val products: List<AllProductsResponse>
)
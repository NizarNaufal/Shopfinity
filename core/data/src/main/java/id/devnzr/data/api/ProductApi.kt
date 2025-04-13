package id.devnzr.data.api

import id.devnzr.data.models.response.AllProductsResponse
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun fetchProductList(): List<AllProductsResponse>
}
package id.devnzr.data.api

import id.devnzr.data.entities.AllProductsSourceApi
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun fetchProductList(): List<AllProductsSourceApi>
}
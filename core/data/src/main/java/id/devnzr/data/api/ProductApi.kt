package id.devnzr.data.api

import id.devnzr.data.models.Products
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun fetchProductList(): List<Products>
}
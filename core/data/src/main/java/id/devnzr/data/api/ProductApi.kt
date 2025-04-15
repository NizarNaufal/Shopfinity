package id.devnzr.data.api

import id.devnzr.data.models.Products
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    suspend fun fetchProductList(): List<Products>

    @GET("products/{id}")
    suspend fun fetchDetailProduct(@Path("id") id: String): Products
}

package id.devnzr.data.api

import id.devnzr.data.models.response.AllCartsResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface CartsApi {
    @GET("carts")
    suspend fun fetchAllCarts(): List<AllCartsResponse>

    @POST("carts")
    suspend fun addCart(): List<AllCartsResponse>
}

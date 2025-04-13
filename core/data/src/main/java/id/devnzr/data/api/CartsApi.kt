package id.devnzr.data.api

import id.devnzr.data.models.Carts
import retrofit2.http.GET
import retrofit2.http.POST

interface CartsApi {
    @GET("carts")
    suspend fun fetchAllCarts(): List<Carts>

    @POST("carts")
    suspend fun addCart(body: Carts): List<Carts>
}

package id.devnzr.data.api

import id.devnzr.data.entities.AllCartsSourceApi
import retrofit2.http.GET
import retrofit2.http.POST

interface CartsApi {
    @GET("carts")
    suspend fun fetchAllCarts(): List<AllCartsSourceApi>

    @POST("carts")
    suspend fun addCart(): List<AllCartsSourceApi>
}

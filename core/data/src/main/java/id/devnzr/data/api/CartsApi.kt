package id.devnzr.data.api

import id.devnzr.data.entities.AllCartsSourceApi
import retrofit2.http.GET

interface CartsApi {
    @GET("carts")
    suspend fun fetchAllCarts(): List<AllCartsSourceApi>
}
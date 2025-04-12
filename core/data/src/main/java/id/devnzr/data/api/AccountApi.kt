package id.devnzr.data.api

import id.devnzr.data.entities.UserSourceApi
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountApi {
    @GET("users/{id}")
    suspend fun fetchUser(
        @Path("id") id: String,
    ): UserSourceApi
}

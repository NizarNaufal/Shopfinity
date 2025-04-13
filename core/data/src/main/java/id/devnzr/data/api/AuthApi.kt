package id.devnzr.data.api

import id.devnzr.data.models.request.LoginRequest
import id.devnzr.data.models.response.LoginResponse
import id.devnzr.data.models.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {
    @GET("users/{id}")
    suspend fun fetchUser(
        @Path("id") id: String,
    ): UserResponse

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}

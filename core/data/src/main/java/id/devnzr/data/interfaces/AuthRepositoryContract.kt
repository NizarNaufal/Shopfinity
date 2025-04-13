package id.devnzr.data.interfaces

import id.devnzr.data.models.request.LoginRequest
import id.devnzr.data.models.response.LoginResponse
import id.devnzr.data.models.response.UserResponse

interface AuthRepositoryContract {
    suspend fun fetchUser(
        id: String,
    ): UserResponse

    suspend fun login(
        body: LoginRequest
    ): LoginResponse

    suspend fun checkToken(): String
}

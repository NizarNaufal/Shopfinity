package id.devnzr.data.repository

import id.devnzr.data.api.AuthApi
import id.devnzr.data.interfaces.AuthRepositoryContract
import id.devnzr.data.models.request.LoginRequest

class AuthRepository(private val api: AuthApi) : AuthRepositoryContract {
    override suspend fun fetchUser(id: String) = api.fetchUser(id)
    override suspend fun login(body: LoginRequest) = api.login(body)
}
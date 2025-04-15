package id.devnzr.data.repository

import id.devnzr.data.api.AuthApi
import id.devnzr.data.interfaces.AuthRepository
import id.devnzr.data.models.request.LoginRequest
import id.devnzr.data.models.response.LoginResponse
import id.devnzr.datastore.DataStoreManager
import kotlinx.coroutines.flow.first

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val dataStore: DataStoreManager
) : AuthRepository {
    override suspend fun fetchUser(id: String) = api.fetchUser(id)
    override suspend fun login(body: LoginRequest): LoginResponse =
        api.login(body).also { response ->
            response.token?.takeIf { it.isNotEmpty() }?.let { dataStore.saveToken(it) }
        }
    override suspend fun checkToken(): String {
        return dataStore.token.first()
    }

    override suspend fun deleteToken() = dataStore.clearToken()
}

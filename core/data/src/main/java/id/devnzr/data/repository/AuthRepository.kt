package id.devnzr.data.repository

import id.devnzr.data.api.AuthApi
import id.devnzr.data.interfaces.AuthRepositoryContract
import id.devnzr.data.models.request.LoginRequest
import id.devnzr.data.models.response.LoginResponse
import id.devnzr.datastore.DataStoreManager
import kotlinx.coroutines.flow.first

class AuthRepository(
    private val api: AuthApi,
    private val dataStore: DataStoreManager
) : AuthRepositoryContract {
    override suspend fun fetchUser(id: String) = api.fetchUser(id)
    override suspend fun login(body: LoginRequest): LoginResponse =
        api.login(body).also { response ->
            response.token?.takeIf { it.isNotEmpty() }?.let { dataStore.saveToken(it) }
        }
    override suspend fun checkToken(): String {
        return dataStore.token.first()
    }
}
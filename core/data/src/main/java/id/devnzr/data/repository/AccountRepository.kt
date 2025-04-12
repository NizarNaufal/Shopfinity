package id.devnzr.data.repository

import id.devnzr.data.api.AccountApi
import id.devnzr.data.interfaces.AccountRepositoryContract

class AccountRepository(private val api: AccountApi) : AccountRepositoryContract {
    override suspend fun fetchUser(id: String) = api.fetchUser(id)
}
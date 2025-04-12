package id.devnzr.data.interfaces

import id.devnzr.data.entities.UserSourceApi

interface AccountRepositoryContract {
    suspend fun fetchUser(
        id: String,
    ): UserSourceApi
}
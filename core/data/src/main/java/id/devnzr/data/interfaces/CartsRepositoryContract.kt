package id.devnzr.data.interfaces

import id.devnzr.data.models.response.AllCartsResponse

interface CartsRepositoryContract {
    suspend fun fetchAllCarts(): List<AllCartsResponse>
    suspend fun addCart(): List<AllCartsResponse>
}
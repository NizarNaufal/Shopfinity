package id.devnzr.data.interfaces

import id.devnzr.data.models.Carts


interface CartsRepositoryContract {
    suspend fun fetchAllCarts(): List<Carts>
    suspend fun addCart(body: Carts): List<Carts>
}
package id.devnzr.data.interfaces

import id.devnzr.data.entities.AllCartsSourceApi

interface CartsRepositoryContract {
    suspend fun fetchAllCarts(): List<AllCartsSourceApi>
}
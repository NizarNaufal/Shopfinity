package id.devnzr.data.repository

import id.devnzr.data.api.CartsApi
import id.devnzr.data.interfaces.CartsRepositoryContract

class CartsRepository(private val api: CartsApi) : CartsRepositoryContract {
    override suspend fun fetchAllCarts() = api.fetchAllCarts()
    override suspend fun addCart() = api.addCart()
}
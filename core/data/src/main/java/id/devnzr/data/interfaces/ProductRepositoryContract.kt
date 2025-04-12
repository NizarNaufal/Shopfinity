package id.devnzr.data.interfaces

import id.devnzr.data.entities.AllProductsSourceApi

interface ProductRepositoryContract {
    suspend fun fetchProductList(): List<AllProductsSourceApi>
}
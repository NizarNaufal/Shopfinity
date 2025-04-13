package id.devnzr.data.interfaces

import id.devnzr.data.models.Products

interface ProductRepositoryContract {
    suspend fun fetchProductList(): List<Products>
}
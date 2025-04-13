package id.devnzr.data.interfaces

import id.devnzr.data.models.Products

interface ProductRepository {
    suspend fun fetchProductList(): List<Products>
}

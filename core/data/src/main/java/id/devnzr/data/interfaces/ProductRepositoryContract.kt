package id.devnzr.data.interfaces

import id.devnzr.data.models.response.AllProductsResponse

interface ProductRepositoryContract {
    suspend fun fetchProductList(): List<AllProductsResponse>
}
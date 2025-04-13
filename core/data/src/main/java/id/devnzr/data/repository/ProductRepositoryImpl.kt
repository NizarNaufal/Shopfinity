package id.devnzr.data.repository

import id.devnzr.data.api.ProductApi
import id.devnzr.data.interfaces.ProductRepository

class ProductRepositoryImpl(private val api: ProductApi) : ProductRepository {
    override suspend fun fetchProductList() = api.fetchProductList()
}

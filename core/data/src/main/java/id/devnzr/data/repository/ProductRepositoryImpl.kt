package id.devnzr.data.repository

import id.devnzr.data.api.ProductApi
import id.devnzr.data.interfaces.ProductRepositoryContract

class ProductRepositoryImpl(private val api: ProductApi) : ProductRepositoryContract {
    override suspend fun fetchProductList() = api.fetchProductList()
}

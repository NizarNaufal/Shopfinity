package id.devnzr.domain.mapper

import id.devnzr.data.entities.AllCartsSourceApi
import id.devnzr.data.entities.AllProductsSourceApi
import id.devnzr.domain.entities.AllCartsEntity
import id.devnzr.domain.entities.ProductEntity

fun List<AllProductsSourceApi>.mapProducts(): List<ProductEntity> = map { it.map() }

fun AllProductsSourceApi.map(): ProductEntity {
    return ProductEntity(
        id = this.id ?: 0,
        title = this.title ?: "",
        price = this.price ?: 0.0,
        description = this.description ?: "",
        category = this.category ?: "",
        image = this.image ?: "",
    )
}
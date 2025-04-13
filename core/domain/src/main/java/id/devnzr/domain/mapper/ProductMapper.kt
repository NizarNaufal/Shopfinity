package id.devnzr.domain.mapper

import id.devnzr.data.models.response.AllProductsResponse
import id.devnzr.domain.entities.ProductEntity

fun List<AllProductsResponse>.mapProducts(): List<ProductEntity> = map { it.map() }

fun AllProductsResponse.map(): ProductEntity {
    return ProductEntity(
        id = this.id ?: 0,
        title = this.title ?: "",
        price = this.price ?: 0.0,
        description = this.description ?: "",
        category = this.category ?: "",
        image = this.image ?: "",
    )
}
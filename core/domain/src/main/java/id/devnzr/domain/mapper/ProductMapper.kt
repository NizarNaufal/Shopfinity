package id.devnzr.domain.mapper

import id.devnzr.domain.models.ProductEntity
import id.devnzr.data.models.Products

fun List<Products>.mapProducts(): List<ProductEntity> = map { it.map() }

fun Products.map(): ProductEntity {
    return ProductEntity(
        id = this.id ?: 0,
        title = this.title ?: "",
        price = this.price ?: 0.0,
        description = this.description ?: "",
        category = this.category ?: "",
        image = this.image ?: "",
    )
}
package id.devnzr.domain.mapper

import id.devnzr.data.models.response.AllCartsResponse
import id.devnzr.domain.entities.AllCartsEntity

fun List<AllCartsResponse>.mapCarts(): List<AllCartsEntity> = map { it.map() }

fun AllCartsResponse.map(): AllCartsEntity {
    return AllCartsEntity(
        id = this.id ?: 0,
        userId = this.userId.orEmpty(),
        products = this.products.mapProducts()
    )
}
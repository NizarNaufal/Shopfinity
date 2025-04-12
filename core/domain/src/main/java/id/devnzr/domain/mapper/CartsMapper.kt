package id.devnzr.domain.mapper

import id.devnzr.data.entities.AllCartsSourceApi
import id.devnzr.domain.entities.AllCartsEntity

fun List<AllCartsSourceApi>.mapCarts(): List<AllCartsEntity> = map { it.map() }

fun AllCartsSourceApi.map(): AllCartsEntity {
    return AllCartsEntity(
        id = this.id ?: 0,
        userId = this.userId.orEmpty(),
        products = this.products.mapProducts()
    )
}
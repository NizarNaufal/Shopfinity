package id.devnzr.domain.mapper

import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.data.models.Carts

fun List<Carts>.mapCarts(): List<AllCartsEntity> = map { it.map() }

fun Carts.map(): AllCartsEntity {
    return AllCartsEntity(
        id = this.id ?: 0,
        userId = this.userId.orEmpty(),
        products = this.products.mapProducts()
    )
}
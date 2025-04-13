package id.devnzr.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CartWithProducts(
    @Embedded val cart: CartsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "cartId"
    )
    val products: List<ProductsEntity>
)


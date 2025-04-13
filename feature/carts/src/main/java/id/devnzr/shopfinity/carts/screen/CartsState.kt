package id.devnzr.shopfinity.carts.screen

import id.devnzr.domain.models.AllCartsEntity

data class CartsState(
    val cartItems: List<AllCartsEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

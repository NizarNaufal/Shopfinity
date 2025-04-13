package id.devnzr.shopfinity.carts.screen

import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.extension.UiEvent

sealed class CartsEvent : UiEvent {
    data object OnLoadCart : CartsEvent()
    data class OnCheckout(val cart: AllCartsEntity) : CartsEvent()
}

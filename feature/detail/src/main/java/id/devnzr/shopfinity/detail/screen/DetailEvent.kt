package id.devnzr.shopfinity.detail.screen

import id.devnzr.extension.UiEvent

sealed class DetailEvent : UiEvent {
    data class OnGetDetailCart(val id: String) : DetailEvent()
    data object OnCheckout : DetailEvent()
    data object OnNavigateBack : DetailEvent()
}

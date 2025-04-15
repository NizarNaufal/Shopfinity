package id.devnzr.shopfinity.home.screen

import id.devnzr.domain.models.ProductEntity
import id.devnzr.extension.UiEvent

sealed class HomeEvent : UiEvent {
    data class OnSearch(val query: String) : HomeEvent()
    data class OnSelectCategory(val category: String) : HomeEvent()
    data class OnAddToCart(val cart: ProductEntity) : HomeEvent()
    data class OnNavigateToDetailProduct(val idProduct: String) : HomeEvent()
    data object OnGetAllProducts : HomeEvent()
    data object OnSubmitSearch : HomeEvent()
    data object OnToggleFilter : HomeEvent()
}

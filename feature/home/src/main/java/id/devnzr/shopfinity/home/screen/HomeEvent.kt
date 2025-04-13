package id.devnzr.shopfinity.home.screen

import id.devnzr.extension.UiEvent

sealed class HomeEvent : UiEvent {
    data object OnGetAllProducts : HomeEvent()
    data class OnSearch(val query: String) : HomeEvent()
    data object OnSubmitSearch : HomeEvent()
    data class OnSelectCategory(val category: String) : HomeEvent()
    data object OnToggleFilter : HomeEvent()
}

package id.devnzr.shopfinity.home.screen

import id.devnzr.domain.entities.ProductEntity
import id.devnzr.domain.utils.ResultState

data class HomeState(
    val searchTerm: String = "",
    val selectedCategory: String = "",
    val isFilterExpanded: Boolean = false,
    val categories: List<ProductEntity>? = emptyList(),
    val resultProduct: ResultState<List<ProductEntity>> = ResultState.Loading(),
    val isLoading: Boolean = false,
    val error: String? = null
)

package id.devnzr.shopfinity.home.screen

import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.domain.models.ProductEntity
import id.devnzr.domain.models.UserEntity
import id.devnzr.domain.utils.ResultState

data class HomeState(
    val searchTerm: String = "",
    val selectedCategory: String = "",
    val isFilterExpanded: Boolean = false,
    val categories: List<String>? = emptyList(),
    val resultProduct: ResultState<List<ProductEntity>> = ResultState.Loading(),
    val selectedByCategories: List<ProductEntity>? = emptyList(),
    val resultUser: ResultState<UserEntity> = ResultState.Loading(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val cartItems: List<AllCartsEntity> = emptyList()
)

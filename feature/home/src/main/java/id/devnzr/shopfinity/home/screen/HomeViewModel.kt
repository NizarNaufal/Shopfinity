package id.devnzr.shopfinity.home.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.interfaces.GetProductListUseCase
import id.devnzr.domain.interfaces.GetUserUseCase
import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.domain.models.ProductEntity
import id.devnzr.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getProductListUseCase: GetProductListUseCase,
    private val addCartsUseCase: AddCartsUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is HomeEvent.OnGetAllProducts -> {
                fetchProducts()
            }

            is HomeEvent.OnSearch -> {
                _state.update { it.copy(searchTerm = event.query) }
//                applyFilter()
            }

            is HomeEvent.OnSubmitSearch -> {
                fetchProducts()
            }

            is HomeEvent.OnSelectCategory -> {
                _state.update { it.copy(selectedCategory = event.category) }
                // need function to selected and show by category
                applyCategoryFilter(event.category)
            }

            is HomeEvent.OnToggleFilter -> {
                _state.update { it.copy(isFilterExpanded = !_state.value.isFilterExpanded) }
            }

            is HomeEvent.OnAddToCart -> {
                addProductToCart(event.cart)
            }
        }
    }

    private fun applyCategoryFilter(selectedCategory: String) {
        val allProducts = _state.value.resultProduct.data ?: emptyList()
        val filteredProducts = if (selectedCategory.isNotBlank()) {
            allProducts.filter { it.category == selectedCategory }
        } else {
            allProducts
        }

        _state.update {
            it.copy(selectedByCategories = filteredProducts)
        }
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            combine(
                getUserUseCase(id = "1"),
                getProductListUseCase()
            ) { user, product ->
                user to product
            }.collect { (user, product) ->
                val selectedCategory = product.data?.firstOrNull()?.category.orEmpty()
                val selectedByCategories = product.data?.filter { it.category == selectedCategory }
                val categories = product.data?.map { it.category }?.distinct()
                _state.update { state ->
                    state.copy(
                        resultUser = user,
                        resultProduct = product,
                        selectedCategory = selectedCategory,
                        selectedByCategories = selectedByCategories,
                        categories = categories,
                        isLoading = false
                    )
                }
            }
        }
    }


    private fun addProductToCart(cart: ProductEntity) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val updatedCarts = addCartsUseCase(
                AllCartsEntity(
                    id = state.value.resultUser.data?.id ?: 0,
                    userId = state.value.resultUser.data?.id.toString(),
                    products = listOf(cart)
                )
            )
            _state.update {
                it.copy(
                    isLoading = false,
                    cartItems = updatedCarts
                )
            }
        }
    }
}

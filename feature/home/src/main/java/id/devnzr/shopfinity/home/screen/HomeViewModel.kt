package id.devnzr.shopfinity.home.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.domain.interfaces.GetProductListUseCase
import id.devnzr.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getProductListUseCase: GetProductListUseCase
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
                applyFilter()
            }

            is HomeEvent.OnSubmitSearch -> {
                fetchProducts()
            }

            is HomeEvent.OnSelectCategory -> {
                _state.update { it.copy(selectedCategory = event.category) }
                applyFilter()
            }

            is HomeEvent.OnToggleFilter -> {
                _state.update { it.copy(isFilterExpanded = !_state.value.isFilterExpanded) }
            }
        }
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getProductListUseCase().collect { result ->
                _state.update {
                    it.copy(
                        resultProduct = result,
                        isLoading = false
                    )
                }
                applyFilter()
            }
        }
    }

    private fun applyFilter() {
        val allProducts = _state.value.resultProduct.data
        val category = _state.value.selectedCategory
        val query = _state.value.searchTerm.lowercase()

        val filtered = allProducts?.filter { product ->
            val matchCategory = category.isBlank() || product.category == category
            val matchName = query.isBlank() || product.title?.lowercase()?.contains(query) == true
            matchCategory && matchName
        }

        _state.update {
            it.copy(categories = filtered)
        }
    }
}

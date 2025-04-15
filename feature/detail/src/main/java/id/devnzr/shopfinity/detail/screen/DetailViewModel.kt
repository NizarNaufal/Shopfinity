package id.devnzr.shopfinity.detail.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.interfaces.GetDetailProductUseCase
import id.devnzr.domain.interfaces.GetUserUseCase
import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.domain.models.ProductEntity
import id.devnzr.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getDetailProductUseCase: GetDetailProductUseCase,
    private val addCartsUseCase: AddCartsUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is DetailEvent.OnGetDetailCart -> fetchDetailProduct(event.id)
            is DetailEvent.OnCheckout -> addProductToCart()
        }
    }

    private fun fetchDetailProduct(id: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            combine(
                getUserUseCase(id = "1"),
                getDetailProductUseCase(id)
            ) { user, product ->
                Pair(user, product)
            }.collect { pair ->
                _state.update {
                    it.copy(
                        resultUser = pair.first,
                        resultProduct = pair.second,
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun addProductToCart() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            addCartsUseCase(
                AllCartsEntity(
                    id = state.value.resultUser.data?.id ?: 0,
                    userId = state.value.resultUser.data?.id.toString(),
                    products = listOf(state.value.resultProduct.data ?: ProductEntity())
                )
            )
            _state.update {
                it.copy(
                    isLoading = false,
                    isSuccessAddToCart = true
                )
            }
        }
    }
}

package id.devnzr.shopfinity.carts.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.interfaces.GetAllCartsUseCase
import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartsViewModel(
    private val getCartsUseCase: GetAllCartsUseCase,
    private val addCartsUseCase: AddCartsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CartsState())
    val state = _state.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is CartsEvent.OnLoadCart -> fetchCarts()
            is CartsEvent.OnCheckout -> addProductToCart(event.cart)
        }
    }

    private fun fetchCarts() {
        viewModelScope.launch {
            getCartsUseCase().collect { result ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        cartItems = result
                    )
                }
            }
        }
    }

    private fun addProductToCart(cart: AllCartsEntity) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val updatedCarts = addCartsUseCase(cart)
            _state.update {
                it.copy(
                    isLoading = false,
                    cartItems = updatedCarts
                )
            }
        }
    }
}

package id.devnzr.shopfinity.detail.screen

import id.devnzr.domain.models.ProductEntity
import id.devnzr.domain.models.UserEntity
import id.devnzr.domain.utils.ResultState

data class DetailState(
    val resultProduct: ResultState<ProductEntity> = ResultState.Idle(),
    val isLoading: Boolean = false,
    val isSuccessAddToCart: Boolean = false,
    val resultUser: ResultState<UserEntity> = ResultState.Loading(),
    val error: String? = null
)

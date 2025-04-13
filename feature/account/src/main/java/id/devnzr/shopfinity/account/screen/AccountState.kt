package id.devnzr.shopfinity.account.screen

import id.devnzr.domain.models.UserEntity
import id.devnzr.domain.utils.ResultState

data class AccountState(
    val isLoading: Boolean = false,
    val resultUser: ResultState<UserEntity> = ResultState.Loading(),
    val resultLogout: ResultState<String> = ResultState.Idle()
)

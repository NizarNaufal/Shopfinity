package id.devnzr.shopfinity.account.screen

import id.devnzr.extension.UiEvent

sealed class AccountEvent: UiEvent {
    data class OnGetAccount(val id: String): AccountEvent()
    data object OnNavigateLogin: AccountEvent()
}
package id.devnzr.shopfinity.login.screen

import id.devnzr.extension.UiEvent

sealed class LoginEvent : UiEvent {
    data class OnInputUsername(val value: String) : LoginEvent()
    data class OnInputPassword(val value: String) : LoginEvent()
    data class OnRememberMeChecked(val value: Boolean) : LoginEvent()
    data object OnForgotPassword : LoginEvent()
    data object OnRegister : LoginEvent()
    data object OnSubmit : LoginEvent()
    data object OnDismissError : LoginEvent()
}

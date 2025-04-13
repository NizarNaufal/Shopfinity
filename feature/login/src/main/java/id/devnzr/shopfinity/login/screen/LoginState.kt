package id.devnzr.shopfinity.login.screen

import id.devnzr.domain.entities.LoginResult
import id.devnzr.domain.utils.ResultState

data class TextFieldState(
    val text: String = "",
    val error: String? = null
)

data class LoginState(
    val username: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val rememberMe: Boolean = false,
    val isLoading: Boolean = false,
    val resultLogin: ResultState<LoginResult> = ResultState.Idle()
)
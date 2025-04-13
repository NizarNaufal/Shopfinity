package id.devnzr.shopfinity.login.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.domain.interfaces.LoginUseCase
import id.devnzr.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is LoginEvent.OnInputUsername -> updateUsername(event.value)
            is LoginEvent.OnInputPassword -> updatePassword(event.value)
            is LoginEvent.OnRememberMeChecked -> updateRememberMe(event.value)
            is LoginEvent.OnSubmit -> handleSubmit()
            else -> Unit
        }
    }

    private fun updateUsername(value: String) = _state.update {
        it.copy(username = TextFieldState(value))
    }

    private fun updatePassword(value: String) = _state.update {
        it.copy(password = TextFieldState(value))
    }

    private fun updateRememberMe(value: Boolean) = _state.update {
        it.copy(rememberMe = value)
    }

    private fun handleSubmit() {
        val username = _state.value.username.text
        val password = _state.value.password.text

        val usernameError = if (username.isBlank()) "Username required" else null
        val passwordError = if (password.isBlank()) "Password required" else null

        if (usernameError != null || passwordError != null) {
            _state.update {
                it.copy(
                    username = it.username.copy(error = usernameError),
                    password = it.password.copy(error = passwordError)
                )
            }
            return
        }

        viewModelScope.launch {
            loginUseCase(username, password).collect {
                _state.update { state ->
                    state.copy(resultLogin = it)
                }
            }
        }
    }
}

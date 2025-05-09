package id.devnzr.shopfinity.account.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.devnzr.domain.interfaces.GetUserUseCase
import id.devnzr.domain.interfaces.LogoutUseCase
import id.devnzr.extension.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class AccountViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AccountState())
    val state get() = _state.asStateFlow()

    fun onEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is AccountEvent.OnGetAccount -> onGetUser(uiEvent.id)
            is AccountEvent.OnNavigateLogin -> onLogout()
        }
    }

    private fun onGetUser(id: String) {
        viewModelScope.launch {
            getUserUseCase(id).collect { result ->
                _state.update { it.copy(resultUser = result) }
            }
        }
    }

    private fun onLogout() {
        viewModelScope.launch {
            logoutUseCase().collect { result ->
                _state.update { it.copy(resultLogout = result) }
            }
        }
    }
}

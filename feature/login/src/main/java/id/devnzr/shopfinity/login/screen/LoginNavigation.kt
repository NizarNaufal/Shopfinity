package id.devnzr.shopfinity.login.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.domain.utils.ResultState
import id.devnzr.extension.Screen
import id.devnzr.shopfinity.core.uikit.LottieLoading
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object LoginNavigation : Screen

fun NavGraphBuilder.loginScreen() {
    composable<LoginNavigation> {
        val viewModel: LoginViewModel = koinViewModel()
        val state: LoginState by viewModel.state.collectAsStateWithLifecycle()
        val activity = LocalContext.current as LoginActivity
        val focusManager = LocalFocusManager.current
        var showError by remember { mutableStateOf(false) }

        LaunchedEffect(state.resultLogin) {
            when (state.resultLogin) {
                is ResultState.Error -> showError = true
                is ResultState.Success -> activity.handleToMainActivity()
                else -> Unit
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            LoginScreen(
                state = state,
                onEvent = { event ->
                    when (event) {
                        is LoginEvent.OnRegister -> {
                            // TODO : Handle navigation to Register Page
                        }
                        is LoginEvent.OnForgotPassword -> {
                            // TODO : Handle navigation to Forgot Password Page
                        }
                        is LoginEvent.OnSubmit -> {
                            focusManager.clearFocus()
                            viewModel.onEvent(LoginEvent.OnSubmit)
                        }
                        else -> viewModel.onEvent(event)
                    }
                }
            )

            if (state.resultLogin is ResultState.Loading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LottieLoading()
                }
            }

            if (showError) {
                AlertDialog(
                    onDismissRequest = { showError = false },
                    title = { Text(text = "Login Failed") },
                    text = {
                        Text(
                            text = state.resultLogin.message.orEmpty(),
                            color = Color.Black
                        )
                    },
                    confirmButton = {
                        TextButton(onClick = { showError = false }) {
                            Text("OK")
                        }
                    }
                )
            }
        }
    }
}

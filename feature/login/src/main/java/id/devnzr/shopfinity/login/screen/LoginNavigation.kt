package id.devnzr.shopfinity.login.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import id.devnzr.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object LoginNavigation : Screen

fun NavGraphBuilder.loginScreen(navController: NavHostController) {
    composable<LoginNavigation> {
        val viewModel: LoginViewModel = koinViewModel()
        val state: LoginState by viewModel.state.collectAsStateWithLifecycle()
        LoginScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is LoginEvent.OnRegister -> {
                        // TODO : Next Action Register Page
                    }
                    is LoginEvent.OnForgotPassword -> {
                        // TODO : Next Action Forgot Password Page
                    }
                    else -> viewModel.onEvent(event)
                }
            }
        )
    }
}
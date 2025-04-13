package id.devnzr.shopfinity.login.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.login.screen.components.LoginForm
import id.devnzr.shopfinity.login.screen.components.LoginHeader

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: OnEvent
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            LoginHeader()
        }
    ) { padding ->
        LoginForm(
            state = state,
            onEvent = onEvent,
            paddingValues = padding
        )
    }
}

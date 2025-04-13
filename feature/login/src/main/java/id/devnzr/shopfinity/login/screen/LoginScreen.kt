package id.devnzr.shopfinity.login.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.login.screen.components.LoginForm
import id.devnzr.shopfinity.login.screen.components.LoginHeader

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: OnEvent
) {
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current

//    LaunchedEffect(true) {
//        viewModel.event.collectLatest { event ->
//            if (event == "login_success") {
//                scaffoldState.snackbarHostState.showSnackbar("Login successful")
//                onLoginSuccess()
//            }
//        }
//    }

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

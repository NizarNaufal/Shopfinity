package id.devnzr.shopfinity.account.screen

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
object AccountNavigation : Screen

fun NavGraphBuilder.accountScreen(navController: NavHostController) {
    composable<AccountNavigation> {
        val viewModel: AccountViewModel = koinViewModel()
        val state: AccountState by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = true, block = {
            viewModel.onEvent(AccountEvent.OnGetAccount("1"))
        })

        AccountScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is AccountEvent.OnNavigateLogin -> {
                    }
                }
            }
        )
    }
}
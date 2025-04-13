package id.devnzr.shopfinity.home.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object HomeNavigation : Screen

fun NavGraphBuilder.homeScreen() {
    composable<HomeNavigation> {
        val viewModel: HomeViewModel = koinViewModel()
        val state: HomeState by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(HomeEvent.OnGetAllProducts)
        }

        HomeScreen(
            state = state,
            onEvent = { event ->
                viewModel.onEvent(event)
            }
        )
    }
}

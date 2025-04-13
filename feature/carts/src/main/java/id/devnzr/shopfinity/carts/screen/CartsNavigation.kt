package id.devnzr.shopfinity.carts.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object CartsNavigation : Screen

fun NavGraphBuilder.cartsScreen() {
    composable<CartsNavigation> {
        val viewModel: CartsViewModel = koinViewModel()
        val state: CartsState by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(CartsEvent.OnLoadCart)
        }

        CartScreen(
            state = state,
        )
    }
}

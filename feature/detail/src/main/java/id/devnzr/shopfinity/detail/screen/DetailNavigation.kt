package id.devnzr.shopfinity.detail.screen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.extension.Screen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object DetailNavigation : Screen

fun NavGraphBuilder.detailScreen() {
    composable<DetailNavigation> {
        val viewModel: DetailViewModel = koinViewModel()
        val state: DetailState by viewModel.state.collectAsStateWithLifecycle()
        val activity = LocalContext.current as DetailActivity

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(DetailEvent.OnGetDetailCart(activity.idProduct))
        }

        DetailScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is DetailEvent.OnNavigateBack -> activity.finish()
                    else -> viewModel.onEvent(event)
                }
            }
        )
    }
}

package id.devnzr.shopfinity.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.devnzr.domain.utils.ResultState
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.core.uikit.LottieLoading
import id.devnzr.shopfinity.core.uikit.cottonBall
import id.devnzr.shopfinity.home.screen.components.CategoriesBestOffersItemComponent
import id.devnzr.shopfinity.home.screen.components.CategoriesItemComponent
import id.devnzr.shopfinity.home.screen.components.TopAppBarItemComponent

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: OnEvent
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(cottonBall)
    ) {
        if (state.resultProduct is ResultState.Loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LottieLoading()
            }
        } else {
            Column {
                Spacer(modifier = Modifier.padding(5.dp))
                TopAppBarItemComponent()
                Spacer(modifier = Modifier.padding(24.dp))
                CategoriesItemComponent(
                    productList = state.selectedByCategories.orEmpty(),
                    state.selectedCategory,
                    state.categories.orEmpty(),
                    onEvent
                )
                Spacer(modifier = Modifier.padding(24.dp))
                CategoriesBestOffersItemComponent(state, onEvent)
                Spacer(modifier = Modifier.padding(24.dp))
            }
        }
    }
}

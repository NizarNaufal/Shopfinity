package id.devnzr.shopfinity.home.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import id.devnzr.domain.utils.ResultState
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.home.R
import id.devnzr.shopfinity.home.screen.components.CategoriesItemComponent
import id.devnzr.shopfinity.home.screen.components.LoadingAnimation
import id.devnzr.shopfinity.home.screen.components.ProductItemComponent
import id.devnzr.shopfinity.home.screen.components.TopAppBarItemComponent

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: OnEvent
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var filtersExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBarItemComponent(
                currentSearchText = "",
                onSearchTextChange = {
                    onEvent(HomeEvent.OnSearch(it))
                },
                onSearch = {
                    keyboardController?.hide()
                    onEvent(HomeEvent.OnSubmitSearch)
                },
                onToggleExpand = {
                    filtersExpanded = !filtersExpanded
                },
            )
        },
    ) {
        DropdownMenu(
            expanded = filtersExpanded,
            offset = DpOffset(x = 200.dp, y = (-600).dp),
            onDismissRequest = {
                filtersExpanded = !filtersExpanded
            }
        ) {
            DropdownMenuItem(
                content = { Text("Clothes") },
                onClick = { Toast.makeText(context, "Clothes", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                content = { Text("Shoes") },
                onClick = { Toast.makeText(context, "Shoes", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                content = { Text("Electronics") },
                onClick = { Toast.makeText(context, "Electronics", Toast.LENGTH_SHORT).show() }
            )
        }

        HomeScreenContent(
            paddingValues = it,
            state = state,
            selectedCategory = state.selectedCategory,
            onSelectCategory = { category ->
                onEvent(HomeEvent.OnSelectCategory(category))
            },
            onEvent= onEvent
        )
    }
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    state: HomeState,
    selectedCategory: String,
    onSelectCategory: (String) -> Unit,
    onEvent: OnEvent
) {
    val products = state.resultProduct
        .let { (it as? ResultState.Success)?.data ?: emptyList() }

    val categories = remember(products) {
        products.mapNotNull { it.category }
            .distinct()
            .sorted()
    }

    Box(modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                Card(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_placeholder),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Black Friday Banner"
                    )
                }
            }

            item(span = { GridItemSpan(2) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item(span = { GridItemSpan(2) }) {
                CategoriesItemComponent(
                    categories = categories,
                    onSelectCategory = onSelectCategory,
                    selectedCategory = selectedCategory
                )
            }

            item(span = { GridItemSpan(2) }) {
                Spacer(modifier = Modifier.height(12.dp))
            }

            items(products) { product ->
                ProductItemComponent(
                    product = product,
                    modifier = Modifier.width(150.dp),
                    onEvent = onEvent
                )
            }
        }

        if (state.resultProduct is ResultState.Loading) {
            LoadingAnimation(
                modifier = Modifier.align(Center),
                circleSize = 16.dp,
            )
        }

        if (state.error != null) {
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Center)
                    .padding(16.dp),
                text = state.error,
                color = Color.Red
            )
        }
    }
}

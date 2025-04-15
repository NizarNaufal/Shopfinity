package id.devnzr.shopfinity.home.screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import id.devnzr.domain.models.ProductEntity
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.core.uikit.paledark
import id.devnzr.shopfinity.home.screen.HomeEvent

@Composable
fun CategoriesItemComponent(
    productList: List<ProductEntity>,
    selectedCategory: String,
    itemList: List<String>,
    onEvent: OnEvent
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(itemList) { item ->
            Box(
                modifier = Modifier
                    .border(
                        color = if (item == selectedCategory) paledark else Color.Transparent,
                        width = 2.dp,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .clickable { onEvent(HomeEvent.OnSelectCategory(item)) }
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                    text = item,
                    color = if (item == selectedCategory) paledark else Color.LightGray
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }

    Spacer(modifier = Modifier.padding(10.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = productList) { item ->
            ProductsItemComponent(
                image = item.image,
                title = item.title,
                price = item.price.toString(),
                onNavigateDetailProduct = {
                    onEvent(HomeEvent.OnNavigateToDetailProduct(item.id.toString()))
                }
            )
        }
    }
}

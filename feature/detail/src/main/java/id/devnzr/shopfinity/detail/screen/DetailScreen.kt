package id.devnzr.shopfinity.detail.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.domain.utils.ResultState
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.core.uikit.LottieLoading
import id.devnzr.shopfinity.detail.screen.components.ProductAddtoCartComponent
import id.devnzr.shopfinity.detail.screen.components.ProductItemComponent
import id.devnzr.shopfinity.detail.screen.components.ProductItemsImageComponent
import id.devnzr.shopfinity.detail.screen.components.TopBarWithBack

@Composable
fun DetailScreen(
    state: DetailState,
    onEvent: OnEvent
) {
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            ProductAddtoCartComponent {
                onEvent(DetailEvent.OnCheckout)
                Toast.makeText(context, "Added to cart!", Toast.LENGTH_SHORT).show()
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                TopBarWithBack(
                    title = "Product",
                    onBackClick = { onEvent(DetailEvent.OnNavigateBack) }
                )

                when (state.resultProduct) {
                    is ResultState.Loading -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 50.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            LottieLoading()
                        }
                    }
                    is ResultState.Success -> {
                        state.resultProduct.data?.let { data ->
                            Column {
                                ProductItemsImageComponent(data.image)
                                ProductItemComponent(
                                    productName = data.title,
                                    category = data.category,
                                    priceProduct = data.price.toString()
                                )
                            }
                        }
                    }
                    is ResultState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Product not found",
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        }
                    }
                    else -> Unit
                }
            }
        }
    }
}

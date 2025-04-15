package id.devnzr.shopfinity.carts.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.shopfinity.carts.R
import id.devnzr.shopfinity.carts.screen.components.CartItemComponent
import id.devnzr.shopfinity.carts.screen.components.CheckoutItemComponent

@Composable
fun CartScreen(
    state: CartsState
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(backgroundColor = Color.White, elevation = 1.dp, title = {
                Text(
                    text = "My Cart",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            })
        },
        backgroundColor = Color.White
    ) { paddingValues ->
        CartScreenContent(
            state = state,
            paddingValues = paddingValues
        )
    }
}

@Composable
private fun CartScreenContent(
    state: CartsState,
    paddingValues: PaddingValues,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        when {
            state.isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }

            state.error != null -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.error,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }
            }

            state.cartItems.isEmpty() -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_artwork),
                        contentDescription = null,
                        modifier = Modifier.size(220.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Cart is Empty", fontSize = 16.sp, color = Color.Black)
                }
            }

            else -> {
                LazyColumn {
                    state.cartItems.forEach { cart ->
                        items(cart.products) { product ->
                            CartItemComponent(product)
                        }
                    }
                    item {
                        CheckoutItemComponent(state)
                    }
                }
            }
        }
    }
}

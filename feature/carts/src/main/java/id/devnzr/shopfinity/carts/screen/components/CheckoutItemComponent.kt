package id.devnzr.shopfinity.carts.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import id.devnzr.shopfinity.carts.screen.CartsState

@Composable
internal fun CheckoutItemComponent(state: CartsState) {
    val totalItems = state.cartItems.sumOf { cart ->
        cart.products.sumOf { it.quantity }
    }
    val totalPrice = state.cartItems.sumOf { cart ->
        cart.products.sumOf { (it.price ?: 0.0) * it.quantity }
    }

    Column(Modifier.padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text("$totalItems items")
            Text("$$totalPrice", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text("Shipping Fee")
            Text("$60.00", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text("Total")
            Text("$${totalPrice + 60.0}", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* handle checkout */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Checkout", textAlign = TextAlign.Center)
        }
    }
}
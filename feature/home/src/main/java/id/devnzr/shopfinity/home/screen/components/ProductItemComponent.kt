package id.devnzr.shopfinity.home.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.core.uikit.texttitlewhite

@Composable
fun ProductsItemComponent(
    image: String,
    title: String = "",
    price: String = "",
    onNavigateDetailProduct : () -> Unit
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .clickable {
                onNavigateDetailProduct()
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = title, maxLines = 1, color = texttitlewhite)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "$ $price", fontWeight = FontWeight.Bold)
        }
    }
}

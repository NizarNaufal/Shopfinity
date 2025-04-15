package id.devnzr.shopfinity.detail.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.shopfinity.core.uikit.paledark
import id.devnzr.shopfinity.core.uikit.texttitlewhite

@Composable
fun ProductItemComponent(productName: String, category: String, priceProduct: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        Column {
            Text(
                text = productName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = paledark,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = category,
                fontSize = 14.sp,
                color = texttitlewhite,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = priceProduct,
                fontSize = 18.sp,
                color = paledark,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

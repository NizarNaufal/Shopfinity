package id.devnzr.shopfinity.detail.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.shopfinity.core.uikit.black
import id.devnzr.shopfinity.core.uikit.paledark

@Composable
fun TopBarWithBack(title: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                modifier = Modifier.size(32.dp, 32.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = black
            )
        }

        Text(
            text = title,
            color = paledark,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        )

        Card(
            modifier = Modifier
                .padding(end = 20.dp)
                .width(50.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = ""
                )

            }
        }
    }

}
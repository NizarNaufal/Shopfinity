package id.devnzr.shopfinity.home.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.shopfinity.core.uikit.paledark

@Composable
fun TopAppBarItemComponent() {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        paledark,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Our ")
                }
                withStyle(
                    style = SpanStyle(
                        paledark
                    )
                ) {
                    append("Products")
                }
            },
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier,
            fontSize = 24.sp

        )

        Card(
            modifier = Modifier.width(50.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = ""
                )
            }
        }

    }
}

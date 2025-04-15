package id.devnzr.shopfinity.home.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import id.devnzr.shopfinity.core.uikit.black
import id.devnzr.shopfinity.core.uikit.paledark
import id.devnzr.shopfinity.core.uikit.texttitlewhite
import id.devnzr.shopfinity.core.uikit.white
import id.devnzr.shopfinity.home.screen.HomeState

@Composable
fun CategoriesBestOffersItemComponent(state: HomeState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    append("Best ")
                }
                withStyle(
                    style = SpanStyle(
                        paledark
                    )
                ) {
                    append("Offers")
                }
            },
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier,
            fontSize = 24.sp
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp)
        ) {
            items(state.resultProduct.data.orEmpty()) { items ->
                CategoryBestOffersItems(
                    image = items.image,
                    title = items.title,
                    price = items.price.toString(),
                )
            }
        }
    }
}

@Composable
fun CategoryBestOffersItems(
    image: String = "",
    title: String = "",
    subtitle: String = "",
    price: String = "",
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Text(
                modifier = Modifier.padding(top = 20.dp, end = 12.dp),
                text = "$ $price",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = black,
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun CategoryMore(
    onNavigateToHome: () -> Unit,
    onNavigateToCart: () -> Unit,
    onNavigateToAccount: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf("Home") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CategoryButton(
            label = "Home",
            selectedCategory = selectedCategory,
            onClick = {
                selectedCategory = "Home"
                onNavigateToHome()
            }
        )
        CategoryButton(
            label = "Cart",
            selectedCategory = selectedCategory,
            onClick = {
                selectedCategory = "Cart"
                onNavigateToCart()
            },
            modifier = Modifier.offset((-60).dp)
        )
        AccountButton(onNavigateToAccount)
    }
}

@Composable
fun CategoryButton(
    label: String,
    selectedCategory: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.clickable { onClick() },
        text = label,
        color = if (selectedCategory == label) texttitlewhite else paledark,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun AccountButton(onNavigateToAccount: () -> Unit) {
    Button(
        onClick = { onNavigateToAccount() },
        modifier = Modifier
            .height(70.dp)
            .width(110.dp)
            .offset(20.dp),
        elevation = null,
        shape = RoundedCornerShape(topStartPercent = 50),
        colors = ButtonDefaults.buttonColors(containerColor = paledark)
    ) {
        Text(text = "Account", color = white, fontSize = 12.sp)
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.padding(start = 5.dp),
            tint = white
        )
    }
}
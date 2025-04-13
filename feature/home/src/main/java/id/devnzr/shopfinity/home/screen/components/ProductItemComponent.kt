package id.devnzr.shopfinity.home.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import id.devnzr.domain.entities.ProductEntity
import id.devnzr.shopfinity.home.R

@Composable
internal fun ProductItemComponent(
    product: ProductEntity,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable {
//                navigator.navigate(ProductDetailsScreenDestination(product))
            },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(CenterHorizontally),
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title.orEmpty(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.category.orEmpty(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraLight
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top,
            ) {
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .align(CenterVertically),
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Text(
                    modifier = Modifier.align(CenterVertically),
                    text = "5/5",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${product.price}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .size(40.dp)
                    .align(End),
                shape = CircleShape,
                border = BorderStroke(0.dp, Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    backgroundColor = Color.Yellow
                )
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

    }
}

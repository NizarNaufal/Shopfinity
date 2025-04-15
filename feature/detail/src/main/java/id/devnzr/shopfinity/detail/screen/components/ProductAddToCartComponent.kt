package id.devnzr.shopfinity.detail.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.core.uikit.addtocart
import id.devnzr.shopfinity.core.uikit.paleBlack
import id.devnzr.shopfinity.core.uikit.white
import id.devnzr.shopfinity.detail.screen.DetailEvent

@Composable
fun ProductAddtoCartComponent(onEvent: OnEvent) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(addtocart),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .offset(1.dp, (-40).dp)
                    .fillMaxWidth(0.2f)
                    .height(70.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                IconButton(
                    onClick = { },
                    Modifier.background(paleBlack)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "",
                        tint = white
                    )

                }
            }
            ClickableText(
                text = AnnotatedString("+ Add to Cart"),
                Modifier.offset(1.dp, (-30).dp),
                onClick = {
                    onEvent(DetailEvent.OnCheckout)
                }
            )
        }
    }
}
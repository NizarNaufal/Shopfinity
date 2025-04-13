package id.devnzr.shopfinity.splash.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import id.devnzr.shopfinity.R

@Composable
fun SplashScreen() {
    SplashContent()
}

@Composable
fun SplashContent() {
    ConstraintLayout(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        val (img) = createRefs()
        Image(
            modifier = Modifier
                .width(150.dp)
                .constrainAs(img) {
                    linkTo(parent.top, parent.bottom)
                    linkTo(parent.start, parent.end)
                },
            painter = painterResource(id = R.drawable.ic_shopfinity),
            contentDescription = ""
        )
    }
}
package id.devnzr.shopfinity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.devnzr.shopfinity.core.uikit.ShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopTheme {
                MainHost()
            }
        }
    }
}

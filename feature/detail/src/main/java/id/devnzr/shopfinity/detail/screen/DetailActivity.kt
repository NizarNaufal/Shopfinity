package id.devnzr.shopfinity.detail.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.devnzr.shopfinity.core.uikit.ShopTheme

class DetailActivity : ComponentActivity() {
    val idProduct by lazy { intent.getStringExtra(ID_PRODUCT).orEmpty() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopTheme {
                DetailHost()
            }
        }
    }

    companion object {
        const val ID_PRODUCT = "id_product"
    }
}

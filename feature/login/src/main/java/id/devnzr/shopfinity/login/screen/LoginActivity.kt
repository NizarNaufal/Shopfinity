package id.devnzr.shopfinity.login.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LoginHost()
            }
        }
    }

    fun handleToMainActivity() {
        val resultIntent = Intent()
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}
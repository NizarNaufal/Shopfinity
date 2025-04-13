package id.devnzr.shopfinity.splash.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.MaterialTheme
import id.devnzr.shopfinity.MainActivity
import id.devnzr.shopfinity.login.screen.LoginActivity

class SplashActivity : ComponentActivity() {

    private val loginActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SplashHost()
            }
        }
    }

    fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        loginActivityResultLauncher.launch(intent)
    }
}

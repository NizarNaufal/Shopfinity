package id.devnzr.shopfinity.login.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginHeader() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Welcome Back", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Login to your account to continue shopping", fontSize = 12.sp)
    }
}

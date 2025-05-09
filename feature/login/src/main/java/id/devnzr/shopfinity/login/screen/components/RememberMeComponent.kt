package id.devnzr.shopfinity.login.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun RememberMeRow(
    rememberMe: Boolean,
    onToggle: (Boolean) -> Unit,
    onForgotPassword: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = rememberMe, onCheckedChange = onToggle)
            Text("Remember me", fontSize = 12.sp)
        }
        TextButton(onClick = onForgotPassword) {
            Text("Forgot password?")
        }
    }
}

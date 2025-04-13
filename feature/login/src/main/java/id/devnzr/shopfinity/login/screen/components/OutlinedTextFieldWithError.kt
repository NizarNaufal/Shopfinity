package id.devnzr.shopfinity.login.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun OutlinedTextFieldWithError(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    error: String? = null,
    isPassword: Boolean = false
) {
    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
            ),
            isError = error != null
        )
        if (!error.isNullOrEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

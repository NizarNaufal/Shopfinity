package id.devnzr.shopfinity.login.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.login.screen.LoginEvent
import id.devnzr.shopfinity.login.screen.LoginState

@Composable
fun LoginForm(
    state: LoginState,
    onEvent: OnEvent,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            OutlinedTextFieldWithError(
                label = "Username",
                value = state.username.text,
                onValueChange = {
                    onEvent(LoginEvent.OnInputUsername(it))
                },
                error = state.username.error
            )
        }

        item {
            Spacer(Modifier.height(16.dp))
            OutlinedTextFieldWithError(
                label = "Password",
                value = state.password.text,
                onValueChange = {
                    onEvent(LoginEvent.OnInputPassword(it))
                },
                error = state.password.error,
                isPassword = true
            )
        }

        item {
            Spacer(Modifier.height(16.dp))
            RememberMeRow(
                rememberMe = state.rememberMe,
                onToggle = {
                    onEvent(LoginEvent.OnRememberMeChecked(it))
                },
                onForgotPassword = {
                    onEvent(LoginEvent.OnForgotPassword)
                }
            )
        }

        item {
            Spacer(Modifier.height(32.dp))
            Button(
                onClick = {
                    onEvent(LoginEvent.OnSubmit)
                },
                enabled = !state.isLoading,
                shape = RoundedCornerShape(8),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign In", modifier = Modifier.padding(12.dp), textAlign = TextAlign.Center)
            }
        }

        item {
            Spacer(Modifier.height(24.dp))
            TextButton(onClick = {
                onEvent(LoginEvent.OnRegister)
            }, modifier = Modifier.fillMaxWidth()) {
                Text(
                    buildAnnotatedString {
                        append("Don't have an account? ")
                        withStyle(SpanStyle(color = Color.Yellow, fontWeight = FontWeight.Bold)) {
                            append("Sign Up")
                        }
                    },
                    textAlign = TextAlign.Center
                )
            }
        }

        if (state.isLoading) {
            item {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

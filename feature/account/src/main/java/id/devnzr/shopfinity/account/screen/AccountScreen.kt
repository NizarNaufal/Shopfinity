package id.devnzr.shopfinity.account.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.domain.models.Account
import id.devnzr.domain.utils.ResultState
import id.devnzr.extension.OnEvent
import id.devnzr.shopfinity.account.screen.components.UserItemComponent

@Composable
fun AccountScreen(
    state: AccountState,
    onEvent: OnEvent
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        backgroundColor = Color.White,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                elevation = 1.dp,
                backgroundColor = Color.White,
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "My Profile",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    ) {
        AccountScreenContent(
            paddingValues = it,
            state = state,
            onClickSignOut = {
                onEvent(AccountEvent.OnNavigateLogin)
            }
        )
    }
}

@Composable
private fun AccountScreenContent(
    paddingValues: PaddingValues,
    state: AccountState,
    onClickSignOut: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        item {
            when (val result = state.resultUser) {
                is ResultState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is ResultState.Success -> {
                    result.data?.let {
                        UserItemComponent(
                            user = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .padding(4.dp)
                        )
                    }
                }

                else -> {
                    Text(
                        text = "Failed to load user.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        items(accountItems) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = item.title,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.content,
                            color = Color.Gray,
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    }
                    IconButton(onClick = { /* Handle click */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                            contentDescription = null
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = onClickSignOut,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "Sign Out",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private val accountItems = listOf(
    Account(
        "My Orders",
        "You have 10 completed orders"
    ),
    Account(
        "Shipping Address",
        "2 addresses have been set"
    ),
    Account(
        "My Reviews",
        "Reviewed 3 items"
    ),
    Account(
        "Settings",
        "Notifications, password, language"
    )
)
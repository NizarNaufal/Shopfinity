package id.devnzr.shopfinity.account.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
internal fun AccountHost() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
        navController = navController,
        startDestination = AccountNavigation,
    ) {
        accountScreen()
    }
}
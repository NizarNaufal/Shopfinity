package id.devnzr.shopfinity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import id.devnzr.shopfinity.account.screen.AccountNavigation
import id.devnzr.shopfinity.account.screen.accountScreen
import id.devnzr.shopfinity.home.screen.HomeNavigation
import id.devnzr.shopfinity.home.screen.homeScreen
import id.devnzr.shopfinity.login.screen.LoginNavigation
import id.devnzr.shopfinity.login.screen.loginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BottomNavHost()
            }
        }
    }
}

@Composable
fun BottomNavHost() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeNavigation::class.qualifiedName.orEmpty(),
            modifier = Modifier.padding(innerPadding)
        ) {
            homeScreen(navController)
            accountScreen(navController)
            loginScreen(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation {
        BottomNavigationItem(
            selected = currentDestination(navController) == HomeNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(HomeNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
        )
        BottomNavigationItem(
            selected = currentDestination(navController) == AccountNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(AccountNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Account") },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Account") }
        )
        BottomNavigationItem(
            selected = currentDestination(navController) == LoginNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(LoginNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Login") },
            icon = { Icon(Icons.Default.Lock, contentDescription = "Login") }
        )
    }
}

@Composable
fun currentDestination(navController: NavHostController): String? {
    return navController.currentBackStackEntry?.destination?.route
}

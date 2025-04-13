package id.devnzr.shopfinity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import id.devnzr.shopfinity.account.screen.AccountNavigation
import id.devnzr.shopfinity.account.screen.accountScreen
import id.devnzr.shopfinity.carts.screen.CartsNavigation
import id.devnzr.shopfinity.carts.screen.cartsScreen
import id.devnzr.shopfinity.home.screen.HomeNavigation
import id.devnzr.shopfinity.home.screen.homeScreen

@Composable
fun MainHost() {
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
            homeScreen()
            accountScreen()
            cartsScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(backgroundColor = Color.White) {
        BottomNavigationItem(
            selected = currentDestination(navController) == HomeNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(HomeNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
        )
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(56.dp)
                .background(Color.Gray, shape = CircleShape)
                .clickable { navController.navigate(CartsNavigation::class.qualifiedName.orEmpty()) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        BottomNavigationItem(
            selected = currentDestination(navController) == AccountNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(AccountNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Account") },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Account") }
        )
    }
}

@Composable
fun currentDestination(navController: NavHostController): String? {
    return navController.currentBackStackEntry?.destination?.route
}

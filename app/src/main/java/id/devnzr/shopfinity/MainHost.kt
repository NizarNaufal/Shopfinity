package id.devnzr.shopfinity

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import id.devnzr.shopfinity.account.screen.AccountNavigation
import id.devnzr.shopfinity.account.screen.accountScreen
import id.devnzr.shopfinity.carts.screen.CartsNavigation
import id.devnzr.shopfinity.carts.screen.cartsScreen
import id.devnzr.shopfinity.detail.screen.DetailActivity
import id.devnzr.shopfinity.home.screen.HomeNavigation
import id.devnzr.shopfinity.home.screen.components.CategoryMore
import id.devnzr.shopfinity.home.screen.homeScreen

@Composable
fun MainHost() {
    val navController = rememberNavController()
    val context = LocalContext.current as MainActivity

    Scaffold(
        bottomBar = {
            CategoryMore(
                onNavigateToHome = {
                    navController.navigate(HomeNavigation::class.qualifiedName.orEmpty()) {
                        popUpTo(HomeNavigation::class.qualifiedName.orEmpty()) { inclusive = true }
                    }
                },
                onNavigateToCart = {
                    navController.navigate(CartsNavigation::class.qualifiedName.orEmpty())
                },
                onNavigateToAccount = {
                    navController.navigate(AccountNavigation::class.qualifiedName.orEmpty())
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeNavigation::class.qualifiedName.orEmpty(),
            modifier = Modifier.padding(innerPadding)
        ) {
            homeScreen(
                onNavigateToDetailProduct = {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("id_product", it)
                    context.startActivity(intent)
                }
            )
            accountScreen()
            cartsScreen()
        }
    }
}

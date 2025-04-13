package id.devnzr.shopfinity.splash.screen

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.devnzr.domain.utils.ResultState
import id.devnzr.extension.Screen
import id.devnzr.shopfinity.MainActivity
import id.devnzr.shopfinity.login.screen.LoginActivity
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object SplashNavigation : Screen

fun NavGraphBuilder.splashScreen() {
    composable<SplashNavigation> {
        val viewModel: SplashViewModel = koinViewModel()
        val activity = LocalContext.current as SplashActivity
        val state: SplashState by viewModel.state.collectAsStateWithLifecycle()
        LaunchedEffect(state.resultState) {
            when(state.resultState)  {
                is ResultState.Success -> {
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    activity.startActivity(intent)
                }

                is ResultState.Error -> {}

                else -> {
                   activity.navigateToLoginActivity()
                }
            }
        }
        SplashScreen()
    }

}
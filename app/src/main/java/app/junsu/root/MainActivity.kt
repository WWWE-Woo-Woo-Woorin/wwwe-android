package app.junsu.root

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.feature_google_sign_in.screen.GoogleSignInScreen
import app.junsu.navigator.navigation.WWWENavigationBar
import app.junsu.navigator.navigation.WWWENavigationHost
import app.junsu.navigator.route.WWWERoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {

                val navController = rememberNavController()

                Scaffold(
                    content = {
                        WWWENavigationHost(
                            navController = navController,
                        )
                    },
                    bottomBar = {
                        WWWENavigationBar(
                            navController = navController,
                        )
                    },
                )

                /*NavHost(
                    navController = navController,
                    startDestination = WWWERoutes.GoogleSignIn.route,
                ) {
                    composable(
                        route = WWWERoutes.GoogleSignIn.route,
                    ) {
                        GoogleSignInScreen(
                            navController = navController,
                        )
                    }
                }

                GoogleSignInScreen(
                    navController = navController,
                )*/
            }
        }
    }
}

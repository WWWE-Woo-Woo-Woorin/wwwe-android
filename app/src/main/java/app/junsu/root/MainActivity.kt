package app.junsu.root

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import app.junsu.common_compose.compositionlocal.User
import app.junsu.navigator.auth.AuthNavigationHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isSignedIn = runBlocking {
            mainViewModel.checkSignedIn()
        }

        setContent {
            MaterialTheme {

                val navController = rememberNavController()

                if (isSignedIn) {

                    val user by remember {
                        mutableStateOf(mainViewModel.user)
                    }

                    CompositionLocalProvider(
                        values = arrayOf(
                            User provides user,
                        ),
                    ) {
                        /*Scaffold(
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
                    )*/
                    }
                } else {
                    AuthNavigationHost(
                        navController = navController,
                    )
                }

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

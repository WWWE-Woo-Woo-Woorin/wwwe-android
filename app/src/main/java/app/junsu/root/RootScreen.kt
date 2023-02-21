package app.junsu.root

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.junsu.core_route.route.WWWERoutes
import app.junsu.navigator.auth.authNavGraph
import app.junsu.navigator.main.mainNavGraph

@Composable
fun RootScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {

    val isSignedIn: Boolean = mainViewModel.checkSignedIn()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        route = WWWERoutes.Root.route,
        startDestination = if (isSignedIn) {
            WWWERoutes.Main.route
        } else {
            WWWERoutes.Auth.route
        },
    ) {

        mainNavGraph(
            navController = navController,
        )

        authNavGraph(
            navController = navController,
        )
    }
}

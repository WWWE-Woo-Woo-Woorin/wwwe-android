package app.junsu.navigator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.navigator.route.WWWERoutes

@Composable
fun WWWENavigationHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = WWWERoutes.Navigation.Community.route,
    ) {

        composable(
            route = WWWERoutes.Navigation.Community.route,
        ) {

        }

        composable(
            route = WWWERoutes.Navigation.Chat.route,
        ) {

        }

        composable(
            route = WWWERoutes.Navigation.Settings.route,
        ) {

        }
    }
}

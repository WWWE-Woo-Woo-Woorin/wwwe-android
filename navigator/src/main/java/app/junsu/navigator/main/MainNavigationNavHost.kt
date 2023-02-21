package app.junsu.navigator.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_chat.screen.ChatListScreen

@Composable
fun MainNavigationNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = WWWERoutes.Main.Navigation.Community.route,
        route = WWWERoutes.Main.Navigation.route,
    ) {

        composable(WWWERoutes.Main.Navigation.Community.route) {
            // todo community
        }

        composable(WWWERoutes.Main.Navigation.Chat.route) {
            ChatListScreen(
                navController = navController,
            )
        }

        composable(WWWERoutes.Main.Navigation.Settings.route) {
            // todo settings
        }
    }
}

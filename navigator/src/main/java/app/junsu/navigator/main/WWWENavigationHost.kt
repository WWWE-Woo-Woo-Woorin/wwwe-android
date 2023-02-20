package app.junsu.navigator.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_chat.screen.ChatListScreen

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
            ChatListScreen(
                navController = navController,
            )
        }

        composable(
            route = WWWERoutes.Navigation.Settings.route,
        ) {

        }
    }
}

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
        startDestination = WWWERoutes.Main.Community.route,
    ) {

        composable(
            route = WWWERoutes.Main.Community.route,
        ) {

        }

        composable(
            route = WWWERoutes.Main.Chat.route,
        ) {
            ChatListScreen(
                navController = navController,
            )
        }

        composable(
            route = WWWERoutes.Main.Settings.route,
        ) {

        }
    }
}

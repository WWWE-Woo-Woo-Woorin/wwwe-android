package app.junsu.navigator.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_chat.screen.ChatListScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = WWWERoutes.Main.Navigation.route,
        route = WWWERoutes.Main.route,
    ) {
        composable(
            route = WWWERoutes.Main.Navigation.route,
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

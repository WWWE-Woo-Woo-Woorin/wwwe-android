package app.junsu.navigator.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_main_nav.screen.MainNavigationScreen

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

            val navigationBarNavController = rememberNavController()

            MainNavigationScreen(
                navigationBarNavController = navigationBarNavController,
                content = {
                    MainNavigationHost(
                        navController = navigationBarNavController,
                    )
                },
            )
        }
    }
}

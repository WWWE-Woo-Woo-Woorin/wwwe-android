package app.junsu.wwwe.ui.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.wwwe.ui.home.Home
import app.junsu.wwwe.ui.home.HomeSections

fun NavGraphBuilder.mainNavigation(
    bottomAppBarTabs: List<HomeSections>,
    onNavigateToCreatePost: () -> Unit,
) {
    navigation(
        route = WwweDestinations.MainNavigation.route,
        startDestination = WwweDestinations.MainNavigation.HOME,
    ) {
        composable(WwweDestinations.MainNavigation.HOME) {
            Home(
                bottomAppBarTabs = bottomAppBarTabs,
                onNavigateToCreatePost = onNavigateToCreatePost,
            )
        }
    }
}

fun NavGraphBuilder.authNavigation() {
    navigation(
        route = WwweDestinations.AuthNavigation.route,
        startDestination = WwweDestinations.AuthNavigation.SIGN_IN,
    ) {
    }
}

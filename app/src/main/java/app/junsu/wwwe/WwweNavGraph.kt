package app.junsu.wwwe

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.wwwe.ui.main.composepost.ComposePost
import app.junsu.wwwe.ui.main.home.Home
import app.junsu.wwwe.ui.main.home.HomeSections
import com.skydoves.landscapist.InternalLandscapistApi

@OptIn(InternalLandscapistApi::class)
fun NavGraphBuilder.mainNavigation(
    bottomAppBarTabs: List<HomeSections>,
    onNavigateToCreatePost: () -> Unit,
    onNavigateUp: () -> Unit,
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
        composable(WwweDestinations.MainNavigation.COMPOSE_POST) {
            ComposePost(
                onNavigateUp = onNavigateUp,
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

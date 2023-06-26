package app.junsu.wwwe.ui.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import app.junsu.wwwe.ui.home.addHomeGraph

fun NavGraphBuilder.wwweNavGraph(
    upPress: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    mainNavigation()
    authNavigation()
}

fun NavGraphBuilder.mainNavigation() {
    navigation(
        route = WwweDestinations.MainNavigation.route,
        startDestination = WwweDestinations.MainNavigation.HOME,
    ) {
        addHomeGraph()
    }
}

fun NavGraphBuilder.authNavigation() {
    navigation(
        route = WwweDestinations.AuthNavigation.route,
        startDestination = WwweDestinations.AuthNavigation.SIGN_IN,
    ) {
    }
}

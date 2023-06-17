package app.junsu.wwwe.ui.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.wwwe.ui.home.HomeSections
import app.junsu.wwwe.ui.home.addHomeGraph

fun NavGraphBuilder.wwweNavGraph(
    upPress: () -> Unit,
) {
    navigation(
        route = WwweDestinations.HOME,
        startDestination = HomeSections.COMMUNITY.route,
    ) {
        addHomeGraph()
    }
    composable(
        route = WwweDestinations.AUTH,
    ) {}
    composable(
        route = WwweDestinations.WALK_THROUGH,
    ) {}
}

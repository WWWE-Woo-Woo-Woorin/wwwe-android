package app.junsu.wwwe.ui.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import app.junsu.wwwe.ui.HomeSections
import app.junsu.wwwe.ui.home.community.CommunityScreen

@Composable
private fun WwweBottomAppBar(
    vararg tabs: HomeSections,
    navController: NavHostController,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    BottomAppBar {
        tabs.forEach { section ->
            val sectionRoute = section.route
            val selected = currentRoute == sectionRoute

            NavigationBarItem(selected = selected, onClick = {
                navController.navigate(
                    route = sectionRoute,
                ) {
                    launchSingleTop = true
                    restoreState = true
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route)
                    }
                }
            }, icon = {
                Icon(
                    imageVector = section.icon,
                    contentDescription = null,
                    tint = if (selected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceTint
                )
            }, label = {
                Text(
                    text = stringResource(
                        id = section.title,
                    ),
                    style = MaterialTheme.typography.labelMedium,
                )
            })
        }
    }
}

fun NavGraphBuilder.addHomeGraph(
    navController: NavHostController,
) {
    composable(
        route = HomeSections.COMMUNITY.route,
    ) { CommunityScreen() }
    composable(HomeSections.CHAT.route) {}
    composable(HomeSections.SETTINGS.route) {}
}

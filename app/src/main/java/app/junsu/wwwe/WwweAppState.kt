package app.junsu.wwwe

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

enum class HomeSections(
    @StringRes val title: Int,
    val route: String,
    val icon: ImageVector,
) {
    COMMUNITY(
        title = R.string.community,
        route = "home/community",
        icon = Icons.Outlined.Home, // TODO: Change Icon
    ),
    CHAT(
        title = R.string.chat,
        route = "home/chat",
        icon = Icons.Outlined.MailOutline, // TODO: Change Icon
    ),
    SETTINGS(
        title = R.string.settings,
        route = "home/settings",
        icon = Icons.Outlined.Settings, // TODO: Change Icon
    ),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberWwweAppState(
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): WwweAppState {
    return remember(
        scaffoldState,
        navController,
        coroutineScope,
    ) {
        WwweAppState(
            scaffoldState = scaffoldState,
            navController = navController,
            coroutineScope = coroutineScope,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Stable
class WwweAppState(
    val scaffoldState: BottomSheetScaffoldState,
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    val bottomAppBarTabs = HomeSections.values()
    private val bottomAppBarRoutes = bottomAppBarTabs.map { it.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route in bottomAppBarRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomAppBarRoute(
        route: String,
    ) {
        if (route != currentRoute) {
            navController.navigate(
                route = route,
            ) {
                launchSingleTop = true
                restoreState = true

                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }
}

private tailrec fun findStartDestination(
    graph: NavDestination,
): NavDestination {
    return if (graph is NavGraph) {
        findStartDestination(
            graph.findNode(
                resId = graph.startDestinationId,
            )!!,
        )
    } else {
        graph
    }
}

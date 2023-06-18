package app.junsu.wwwe.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import app.junsu.wwwe.R
import app.junsu.wwwe.ui.home.community.Community
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

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

fun NavGraphBuilder.addHomeGraph() {
    composable(
        route = HomeSections.COMMUNITY.route,
    ) { Community() }
    composable(HomeSections.CHAT.route) {
        ChatTheme {
            ChannelsScreen(
                title = stringResource(R.string.app_name),
                isShowingSearch = true,
                onItemClick = { channel ->
                    // TODO Start Messages Activity
                },
                onBackPressed = {}
            )
        }
    }
    composable(HomeSections.SETTINGS.route) {}
}

@Composable
fun WwweBottomAppBar(
    vararg tabs: HomeSections,
    navController: NavHostController,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    BottomAppBar {
        tabs.forEach { section ->
            val sectionRoute = section.route
            val selected = currentRoute == sectionRoute

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(
                        route = sectionRoute,
                    ) {
                        launchSingleTop = true
                        restoreState = true
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = section.icon,
                        contentDescription = null,
                        tint = if (selected) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.secondary
                        },
                    )
                },
                label = {
                    Text(
                        text = stringResource(section.title),
                        style = MaterialTheme.typography.labelMedium,
                    )
                },
                alwaysShowLabel = false,
            )
        }
    }
}

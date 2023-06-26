package app.junsu.wwwe.ui.main.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.wwwe.R
import app.junsu.wwwe.ui.main.home.community.Community
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@Composable
fun Home(
    modifier: Modifier = Modifier,
    bottomAppBarTabs: List<HomeSections>,
    onNavigateToCreatePost: () -> Unit,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WwweBottomAppBar(
                tabs = bottomAppBarTabs,
                navController = navController,
            )
        },
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            navController = navController,
            startDestination = HomeSections.COMMUNITY.route,
        ) {
            composable(HomeSections.COMMUNITY.route) {
                Community(
                    onNavigateToCreatePost = onNavigateToCreatePost,
                )
            }
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
    }
}

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

@Composable
fun WwweBottomAppBar(
    tabs: List<HomeSections>,
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

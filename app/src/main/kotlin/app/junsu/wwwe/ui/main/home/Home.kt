package app.junsu.wwwe.ui.main.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.wwwe.R
import app.junsu.wwwe.ui.main.home.chat.ChatScreen
import app.junsu.wwwe.ui.main.home.community.CommunityScreen

@Composable
fun Home(
    modifier: Modifier = Modifier,
    bottomAppBarTabs: List<HomeSections>,
    onNavigateToCreatePost: () -> Unit,
    onNavigateToMessages: (channelId: String) -> Unit,
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
        containerColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            navController = navController,
            startDestination = HomeSections.COMMUNITY.route,
        ) {
            composable(HomeSections.COMMUNITY.route) {
                CommunityScreen(
                    modifier = Modifier.fillMaxSize(),
                    onNavigateToCreatePost = onNavigateToCreatePost,
                )
            }
            composable(HomeSections.CHAT.route) {
                ChatScreen(
                    onNavigateUp = navController::navigateUp,
                    onNavigateToMessages = onNavigateToMessages,
                )
            }
            composable(HomeSections.SETTINGS.route) {}
        }
    }
}

enum class HomeSections(
    @StringRes val title: Int,
    val route: String,
    val defaultIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    COMMUNITY(
        title = R.string.community,
        route = "home/community",
        defaultIcon = Icons.Outlined.Feed,
        selectedIcon = Icons.Filled.Feed,
    ),
    CHAT(
        title = R.string.chat,
        route = "home/chat",
        defaultIcon = Icons.Outlined.ChatBubbleOutline,
        selectedIcon = Icons.Filled.ChatBubble,
    ),
    SETTINGS(
        title = R.string.settings,
        route = "home/settings",
        defaultIcon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings,
    ), ;
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
                        modifier = Modifier.size(24.dp),
                        imageVector = if (selected) section.selectedIcon else section.defaultIcon,
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

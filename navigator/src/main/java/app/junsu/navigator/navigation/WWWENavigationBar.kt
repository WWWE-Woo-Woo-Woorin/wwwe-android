package app.junsu.navigator.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.navigator.R
import app.junsu.navigator.route.WWWERoutes

private val navigationBarItems = listOf(
    NavigationBarItem(
        label = "Community",
        selectedIcon = R.drawable.ic_community_filled,
        defaultIcon = R.drawable.ic_community_outlined,
        route = WWWERoutes.Navigation.Community.route,
    ),
    NavigationBarItem(
        label = "Chat", // todo set as a preference of strings resource
        selectedIcon = R.drawable.ic_chat_filled,
        defaultIcon = R.drawable.ic_chat_outlined,
        route = WWWERoutes.Navigation.Chat.route,
    ),
    NavigationBarItem(
        label = "Settings",
        selectedIcon = R.drawable.ic_settings_filled,
        defaultIcon = R.drawable.ic_settings_outlined,
        route = WWWERoutes.Navigation.Settings.route,
    ),
)

@Composable
fun WWWENavigationBar(
    navController: NavHostController,
) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = backStackEntry?.destination?.route

    NavigationBar {
        navigationBarItems.forEach { navigationBarItem ->
            NavigationBarItem(selected = currentRoute == navigationBarItem.route, onClick = {
                navController.navigate(
                    navigationBarItem.route,
                ) {

                    popUpTo(
                        navController.graph.findStartDestination().id,
                    ) {
                        saveState = true
                    }

                    launchSingleTop = true

                    restoreState = true
                }
            }, icon = {
                Icon(
                    painter = painterResource(
                        id = if (currentRoute == navigationBarItem.route) {
                            navigationBarItem.selectedIcon
                        } else {
                            navigationBarItem.defaultIcon
                        },
                    ),
                    contentDescription = null,
                )
            }, label = {
                Text(
                    text = navigationBarItem.label,
                )
            })
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun WWWENavigationBarPreview() {

    val navController = rememberNavController()

    Scaffold(
        content = {
            WWWENavigationHost(
                navController = navController,
            )
        },
        bottomBar = {
            WWWENavigationBar(
                navController = navController,
            )
        },
    )
}
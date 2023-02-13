package app.junsu.navigator.navigation

import androidx.compose.runtime.Composable
import app.junsu.navigator.R
import app.junsu.navigator.route.WWWERoutes

private val navigationBarItem = listOf(
    NavigationBarItem(
        label = "Community",
        icon = R.drawable.ic_community_filled,
        route = WWWERoutes.Navigation.Community.route,
    ),
    NavigationBarItem(
        label = "Chat", // todo set as a preference of strings resource
        icon = R.drawable.ic_chat_filled,
        route = WWWERoutes.Navigation.Chat.route,
    ),
    NavigationBarItem(
        label = "Settings",
        icon = R.drawable.ic_settings_filled,
        route = WWWERoutes.Navigation.Settings.route,
    ),
)

@Composable
fun WWWENavigationBar() {

}

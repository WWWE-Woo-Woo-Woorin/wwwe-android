package app.junsu.wwwe.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.wwwe.ui.home.community.CommunityScreen

val bottomTabs = HomeSections.values()

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            WwweBottomBar(
                tabs = arrayOf(*bottomTabs),
                navController = navController,
            )
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeSections.COMMUNITY.route,
        ) {}
    }
}

fun NavGraphBuilder.addHomeGraph() {
    composable(HomeSections.COMMUNITY.route) { CommunityScreen() }
    composable(HomeSections.CHAT.route) {}
    composable(HomeSections.SETTINGS.route) {}
}

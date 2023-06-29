package app.junsu.wwwe.util

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import app.junsu.wwwe.WwweDestinations

fun NavHostController.navigateToHomeNav() {
    this.navigate(WwweDestinations.MainNavigation.route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(this@navigateToHomeNav.graph.findStartDestination().id) {
            inclusive = true
        }
    }
}

fun NavHostController.navigateToCreatePost() {
    this.navigate(WwweDestinations.MainNavigation.COMPOSE_POST) {
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateToMessages(channelId: String) {
    this.navigate(WwweDestinations.MainNavigation.CHAT_MESSAGES + "/$channelId") {
        launchSingleTop = true
        restoreState = true
    }
}

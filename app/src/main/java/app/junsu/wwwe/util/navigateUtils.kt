package app.junsu.wwwe.util

import androidx.navigation.NavHostController
import app.junsu.wwwe.ui.navigator.WwweDestinations

fun NavHostController.navigateToCreatePost() {
    this.navigate(WwweDestinations.MainNavigation.CREATE_POST) {
        launchSingleTop = true
        restoreState = true
    }
}

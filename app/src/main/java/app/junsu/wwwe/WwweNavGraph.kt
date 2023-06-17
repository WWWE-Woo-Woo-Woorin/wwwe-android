package app.junsu.wwwe

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun WwweNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = WwweDestinations.HOME,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(WwweDestinations.HOME) {}
        composable(WwweDestinations.AUTH) {}
        composable(WwweDestinations.WALK_THROUGH) {}
    }
}

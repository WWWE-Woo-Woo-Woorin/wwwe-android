package app.junsu.wwwe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import app.junsu.wwwe.ui.home.addHomeGraph
import app.junsu.wwwe.ui.theme.WwweTheme

@Composable
fun WwweApp() {
    WwweTheme {
        val navController = rememberNavController()
        val startDestination = WwweDestinations.HOME

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            NavHost(
                navController = navController,
                startDestination = startDestination,
            ) {
                wwweNavGraph(
                    navController = navController,
                )
            }
        }
    }
}

fun NavGraphBuilder.wwweNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = WwweDestinations.HOME,
        startDestination = HomeSections.COMMUNITY.route,
    ) {
        addHomeGraph(
            navController = navController,
        )
    }
    composable(
        route = WwweDestinations.AUTH,
    ) {}
    composable(
        route = WwweDestinations.WALK_THROUGH,
    ) {}
}

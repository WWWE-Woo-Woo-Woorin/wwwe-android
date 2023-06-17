package app.junsu.wwwe

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.wwwe.ui.home.WwweBottomAppBar
import app.junsu.wwwe.ui.home.addHomeGraph
import app.junsu.wwwe.ui.theme.WwweTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WwweApp() {
    WwweTheme {
        val appState = rememberWwweAppState()

        Scaffold(
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    WwweBottomAppBar(
                        tabs = appState.bottomAppBarTabs,
                        navController = appState.navController,
                    )
                }
            },
        ) { paddingValues ->
            NavHost(
                navController = appState.navController,
                startDestination = WwweDestinations.HOME,
                modifier = Modifier.padding(
                    paddingValues = paddingValues,
                ),
            ) {
                wwweNavGraph(
                    upPress = appState::upPress,
                )
            }
        }
    }
}

fun NavGraphBuilder.wwweNavGraph(
    upPress: () -> Unit,
) {
    navigation(
        route = WwweDestinations.HOME,
        startDestination = HomeSections.COMMUNITY.route,
    ) {
        addHomeGraph()
    }
    composable(
        route = WwweDestinations.AUTH,
    ) {}
    composable(
        route = WwweDestinations.WALK_THROUGH,
    ) {}
}

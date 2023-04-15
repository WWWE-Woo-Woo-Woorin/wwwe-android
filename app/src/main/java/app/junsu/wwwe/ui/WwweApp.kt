package app.junsu.wwwe.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.junsu.wwwe.ui.theme.WwweTheme

@Composable
fun WwweApp() {
    WwweTheme {
        val navController = rememberNavController()
        val startDestination = TODO()

        NavHost(
            navController = navController,
            startDestination = startDestination,
        ) {

        }

    }
}

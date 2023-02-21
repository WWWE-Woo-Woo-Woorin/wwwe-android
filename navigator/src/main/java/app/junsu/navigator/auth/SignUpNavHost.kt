package app.junsu.navigator.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_sign_up.screen.SignUpUsernameScreen

@Composable
fun SignUpNavHost(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = WWWERoutes.Auth.SignUp.route,
    ) {

        composable(WWWERoutes.Auth.SignUp.Username.route) {
            SignUpUsernameScreen(
                navController = navController,
            )
        }

        composable(WWWERoutes.Auth.SignUp.ProfileImage.route) {
            // todo enter profile screen
        }
    }
}

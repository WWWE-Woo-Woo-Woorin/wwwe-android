package app.junsu.feature_sign_up.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.core_route.route.WWWERoutes

@Composable
fun SignUpRootScreen(
    navController: NavHostController,
) {

    val signUpNavController = rememberNavController()

    NavHost(
        navController = signUpNavController,
        startDestination = WWWERoutes.Auth.SignUp.Username.route,
        route = WWWERoutes.Auth.SignUp.route,
    ) {

        composable(WWWERoutes.Auth.SignUp.Username.route) {
            SignUpUsernameScreen(
                navController = signUpNavController,
            )
        }

        composable(WWWERoutes.Auth.SignUp.ProfileImage.route) {
            SignUpProfileImageScreen(
                navController = signUpNavController,
            )
        }
    }
}

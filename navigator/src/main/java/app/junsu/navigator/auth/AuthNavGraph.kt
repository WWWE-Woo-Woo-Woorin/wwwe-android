package app.junsu.navigator.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_google_sign_in.screen.GoogleSignInScreen
import app.junsu.feature_onboarding.screen.OnBoardingScreen
import app.junsu.feature_sign_up.screen.SignUpRootScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = WWWERoutes.Auth.OnBoarding.route,
        route = WWWERoutes.Auth.route,
    ) {

        composable(WWWERoutes.Auth.OnBoarding.route) {
            OnBoardingScreen(
                navController = navController,
            )
        }

        composable(WWWERoutes.Auth.GoogleSignIn.route) {
            GoogleSignInScreen(
                navController = navController,
            )
        }

        composable(WWWERoutes.Auth.SignUp.route) {
            SignUpRootScreen(
                navController = navController,
            )
        }
    }
}

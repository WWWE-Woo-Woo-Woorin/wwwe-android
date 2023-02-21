package app.junsu.navigator.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_google_sign_in.screen.GoogleSignInScreen
import app.junsu.feature_onboarding.screen.onboarding.OnBoardingScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
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

        // todo signup screen
    }
}

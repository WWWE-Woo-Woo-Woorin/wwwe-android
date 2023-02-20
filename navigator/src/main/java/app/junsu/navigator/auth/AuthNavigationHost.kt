package app.junsu.navigator.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_google_sign_in.screen.GoogleSignInScreen
import app.junsu.feature_onboarding.screen.onboarding.OnBoardingScreen

@Composable
fun AuthNavigationHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = WWWERoutes.Auth.OnBoarding.route,
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
package app.junsu.navigator.auth

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_google_sign_in.screen.GoogleSignInScreen
import app.junsu.feature_onboarding.screen.onboarding.OnBoardingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthNavHost(
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

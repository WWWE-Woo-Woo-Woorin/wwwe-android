package app.junsu.navigator.main

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_chat.screen.ChatListScreen
import app.junsu.navigator._navigation.WWWENavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavHost(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            WWWENavigationBar(
                navController = navController,
            )
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = WWWERoutes.Main.Community.route,
            ) {

                composable(
                    route = WWWERoutes.Main.Community.route,
                ) {

                }

                composable(
                    route = WWWERoutes.Main.Chat.route,
                ) {
                    ChatListScreen(
                        navController = navController,
                    )
                }

                composable(
                    route = WWWERoutes.Main.Settings.route,
                ) {

                }
            }
        },
    )
}

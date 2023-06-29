package app.junsu.wwwe

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import app.junsu.wwwe.ui.auth.signin.SignInScreen
import app.junsu.wwwe.ui.main.composepost.ComposePostScreen
import app.junsu.wwwe.ui.main.home.Home
import app.junsu.wwwe.ui.main.home.HomeSections
import com.skydoves.landscapist.InternalLandscapistApi
import io.getstream.chat.android.compose.ui.messages.MessagesScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@OptIn(InternalLandscapistApi::class)
fun NavGraphBuilder.mainNavigation(
    bottomAppBarTabs: List<HomeSections>,
    onNavigateToCreatePost: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    navigation(
        route = WwweDestinations.MainNavigation.route,
        startDestination = WwweDestinations.MainNavigation.HOME,
    ) {
        composable(WwweDestinations.MainNavigation.HOME) {
            Home(
                bottomAppBarTabs = bottomAppBarTabs,
                onNavigateToCreatePost = onNavigateToCreatePost,
            )
        }
        composable(WwweDestinations.MainNavigation.COMPOSE_POST) {
            ComposePostScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateUp = onNavigateUp,
            )
        }
        composable(
            route = WwweDestinations.MainNavigation.CHAT_MESSAGES + "/{channelId}",
            arguments = listOf(navArgument("channelId") { type = NavType.StringType }),
        ) { backStackEntry ->
            backStackEntry.arguments?.run {
                val channelId = this.getString("channelId")!!
                ChatTheme {
                    MessagesScreen(
                        channelId = channelId,
                    )
                }
            }
        }
    }
}

fun NavGraphBuilder.authNavigation(
    onNavigateToHomeNav: () -> Unit,
) {
    navigation(
        route = WwweDestinations.AuthNavigation.route,
        startDestination = WwweDestinations.AuthNavigation.SIGN_IN,
    ) {
        composable(WwweDestinations.AuthNavigation.SIGN_IN) {
            SignInScreen(onNavigateToHomeNav = onNavigateToHomeNav)
        }
    }
}

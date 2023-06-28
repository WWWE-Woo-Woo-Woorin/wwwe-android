package app.junsu.wwwe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import app.junsu.wwwe.ui.theme.WwweTheme
import app.junsu.wwwe.util.navigateToCreatePost
import app.junsu.wwwe.util.navigateToHomeNav
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.offline.model.message.attachments.UploadAttachmentsNetworkType
import io.getstream.chat.android.offline.plugin.configuration.Config
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val offlinePluginFactory = StreamOfflinePluginFactory(
            config = Config(
                backgroundSyncEnabled = true,
                userPresence = true,
                persistenceEnabled = true,
                uploadAttachmentsNetworkType = UploadAttachmentsNetworkType.NOT_ROAMING,
            ),
            appContext = applicationContext,
        )

        val client =
            ChatClient.Builder("ekhu33sa6879", applicationContext).withPlugin(offlinePluginFactory)
                .logLevel(ChatLogLevel.ALL) // Set to NOTHING in prod
                .build()

        val user = User(
            id = "tutorial-droid",
            name = "Tutorial Droid",
            image = "https://bit.ly/2TIt8NR",
        )

        val token = client.devToken(
            userId = user.id,
        )

        client.connectUser(
            user = user,
            token = token,
        ).enqueue()

        setContent {
            val sideEffect by viewModel.sideEffectFlow.collectAsState()
            val initialRoute by remember {
                mutableStateOf(
                    when (sideEffect) {
                        MainSideEffect.TokenAvailable -> WwweDestinations.MainNavigation.route
                        MainSideEffect.TokenNotAvailable -> WwweDestinations.AuthNavigation.route
                        null -> WwweDestinations.MainNavigation.route
                    },
                )
            }

            WwweApp(
                modifier = Modifier.fillMaxSize(),
                initialRoute = initialRoute,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WwweApp(
    modifier: Modifier = Modifier,
    initialRoute: String,
) {
    WwweTheme {
        val appState = rememberWwweAppState()
        val navController = appState.navController

        NavHost(
            modifier = modifier.fillMaxSize(),
            navController = navController,
            startDestination = initialRoute,
        ) {
            mainNavigation(
                bottomAppBarTabs = appState.bottomAppBarTabs,
                onNavigateToCreatePost = navController::navigateToCreatePost,
                onNavigateUp = navController::navigateUp,
            )
            authNavigation(
                onNavigateToHomeNav = navController::navigateToHomeNav,
            )
        }
    }
}

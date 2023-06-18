package app.junsu.wwwe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import app.junsu.wwwe.ui.home.WwweBottomAppBar
import app.junsu.wwwe.ui.navigator.WwweDestinations
import app.junsu.wwwe.ui.navigator.wwweNavGraph
import app.junsu.wwwe.ui.signin.SignInScreen
import app.junsu.wwwe.ui.theme.WwweTheme
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.offline.model.message.attachments.UploadAttachmentsNetworkType
import io.getstream.chat.android.offline.plugin.configuration.Config
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

class MainActivity : ComponentActivity() {
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

        val client = ChatClient.Builder("ekhu33sa6879", applicationContext)
            .withPlugin(offlinePluginFactory)
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
            WwweApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WwweApp() {
    WwweTheme {
        val appState = rememberWwweAppState()

        /*Scaffold(
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    WwweBottomAppBar(
                        tabs = appState.bottomAppBarTabs,
                        navController = appState.navController,
                    )
                }
            },
        ) { paddingValues ->
            NavHost(
                navController = appState.navController,
                startDestination = WwweDestinations.HOME,
                modifier = Modifier.padding(
                    paddingValues = paddingValues,
                ),
            ) {
                wwweNavGraph(
                    upPress = appState::upPress,
                )
            }
        }*/
        SignInScreen()
    }
}

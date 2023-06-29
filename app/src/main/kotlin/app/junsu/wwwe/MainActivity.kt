package app.junsu.wwwe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import app.junsu.wwwe.ui.theme.WwweTheme
import app.junsu.wwwe.util.navigateToCreatePost
import app.junsu.wwwe.util.navigateToHomeNav
import app.junsu.wwwe.util.navigateToMessages
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.offline.model.message.attachments.UploadAttachmentsNetworkType
import io.getstream.chat.android.offline.plugin.configuration.Config
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory
import java.util.Date
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationFlipperPlugin()
        initStreamChatClient()

        setContent {
            val regenerateTokenSuccess by remember { mutableStateOf(viewModel.regenerateToken()) }
            WwweApp(
                modifier = Modifier.fillMaxSize(),
                initialRoute = if (regenerateTokenSuccess) WwweDestinations.MainNavigation.route
                else WwweDestinations.AuthNavigation.route,
            )
        }
    }

    private fun initStreamChatClient() {
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
    }

    private fun initNavigationFlipperPlugin() {
        lifecycleScope.launch {
            delay(500)
            NavigationFlipperPlugin.getInstance().sendNavigationEvent(
                this.javaClass.simpleName,
                this.javaClass.simpleName,
                Date(),
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
                onNavigateToMessages =  navController::navigateToMessages,
            )
            authNavigation(
                onNavigateToHomeNav = navController::navigateToHomeNav,
            )
        }
    }
}

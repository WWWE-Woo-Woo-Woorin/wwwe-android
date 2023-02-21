package app.junsu.feature_chat.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.junsu.common_compose.compositionlocal.User
import app.junsu.feature_chat.BuildConfig
import app.junsu.feature_chat.viewmodel.ChatViewModel
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.chat.android.compose.ui.theme.StreamColors
import io.getstream.chat.android.offline.plugin.configuration.Config
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

@Composable
fun ChatListScreen(
    navController: NavController,
    chatViewModel: ChatViewModel = hiltViewModel(),
) {

    val offlinePluginFactory = StreamOfflinePluginFactory(
        config = Config(),
        appContext = LocalContext.current,
    )

    val chatClient = ChatClient.Builder(
        apiKey = BuildConfig.STREAM_CHAT_ACCESS_KEY,
        appContext = LocalContext.current,
    ).withPlugin(
        pluginFactory = offlinePluginFactory,
    ).logLevel(
        level = ChatLogLevel.ALL,
    ).build()

    val user = with(User.current) {
        User(
            id = email.substring(0..4),
            name = username,
            image = profileUrl!!,
        )
    }

    val token = chatClient.devToken(
        userId = user.id,
    )

    chatClient.connectUser(
        user = user,
        token = token,
    ).enqueue()

    ChatTheme(
        colors = if (isSystemInDarkTheme()) {
            StreamColors.defaultDarkColors()
        } else {
            StreamColors.defaultColors()
        }
    ) {
        ChannelsScreen(
            isShowingSearch = true,
        )
    }
}

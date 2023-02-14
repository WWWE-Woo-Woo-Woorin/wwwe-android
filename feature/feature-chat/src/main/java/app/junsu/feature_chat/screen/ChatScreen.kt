package app.junsu.feature_chat.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import app.junsu.feature_chat.BuildConfig
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.offline.plugin.configuration.Config
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

@Composable
fun ChatScreen() {

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

    val user = User(
        id =
    )

}

package app.junsu.wwwe.ui.main.home.chat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import app.junsu.wwwe.R
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        ChatTheme {
            ChannelsScreen(
                title = stringResource(R.string.chat),
                isShowingSearch = false,
                onItemClick = { channel ->
                    // TODO Start Messages Activity
                },
                onBackPressed = {}
            )
        }
    }
}

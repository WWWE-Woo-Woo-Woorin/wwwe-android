package app.junsu.wwwe.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import app.junsu.wwwe.R

enum class HomeSections(
    @StringRes val title: Int,
    val route: String,
    val icon: ImageVector,
) {
    COMMUNITY(
        title = R.string.community,
        route = "home/community",
        icon = Icons.Outlined.Home, // TODO: Change Icon
    ),
    CHAT(
        title = R.string.chat,
        route = "home/chat",
        icon = Icons.Outlined.MailOutline, // TODO: Change Icon
    ),
    SETTINGS(
        title = R.string.settings,
        route = "home/settings",
        icon = Icons.Outlined.Settings, // TODO: Change Icon
    ),
}

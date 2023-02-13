package app.junsu.common_compose.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
)

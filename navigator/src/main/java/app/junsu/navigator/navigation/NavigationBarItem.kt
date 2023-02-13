package app.junsu.navigator.navigation

data class NavigationBarItem(
    val label: String,
    val selectedIcon: Int,
    val defaultIcon: Int,
    val route: String,
)

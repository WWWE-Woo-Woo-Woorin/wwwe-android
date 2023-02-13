package app.junsu.navigator.route

sealed class WWWERoutes(
    val route: String,
) {

    object Navigation {

        object Community : WWWERoutes(
            route = "community",
        )

        object Chat : WWWERoutes(
            route = "chat",
        )

        object Settings : WWWERoutes(
            route = "settings",
        )
    }

    object GoogleSignIn : WWWERoutes(
        route = "googleSignIn",
    )

    object OnBoarding : WWWERoutes(
        route = "onBoarding",
    )

    object Home : WWWERoutes(
        route = "home",
    )
}

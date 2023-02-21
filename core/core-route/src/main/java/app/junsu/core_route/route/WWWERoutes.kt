package app.junsu.core_route.route

sealed class WWWERoutes(
    val route: String,
) {

    object Main : WWWERoutes(
        route = "main",
    ) {

        @Deprecated("no")
        object Community : WWWERoutes(
            route = "community",
        )

        @Deprecated("no")
        object Chat : WWWERoutes(
            route = "chat",
        )

        @Deprecated("no")
        object Settings : WWWERoutes(
            route = "settings",
        )

        object Navigation : WWWERoutes(
            route = "mainNavigation",
        ) {

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
    }

    object Auth : WWWERoutes(
        route = "auth",
    ) {

        object OnBoarding : WWWERoutes(
            route = "onBoarding",
        )

        object GoogleSignIn : WWWERoutes(
            route = "googleSignIn",
        )

        object SignUp : WWWERoutes(
            route = "signUp",
        )
    }
}

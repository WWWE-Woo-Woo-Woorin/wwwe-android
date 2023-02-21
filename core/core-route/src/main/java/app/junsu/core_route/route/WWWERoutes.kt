package app.junsu.core_route.route

sealed class WWWERoutes(
    val route: String,
) {

    object Root : WWWERoutes(
        route = "root",
    )

    object Main : WWWERoutes(
        route = "main",
    ) {
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
        ) {

            object Username : WWWERoutes(
                route = "username",
            )

            object ProfileImage : WWWERoutes(
                route = "profileImage",
            )
        }
    }
}

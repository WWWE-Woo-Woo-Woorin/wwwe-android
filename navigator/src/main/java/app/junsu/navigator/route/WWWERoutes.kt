package app.junsu.navigator

sealed class WWWERoutes(
    val route: String,
) {

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

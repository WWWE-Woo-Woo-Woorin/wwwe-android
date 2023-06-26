package app.junsu.wwwe.ui.navigator

sealed class WwweDestinations(
    val route: String,
) {
    object AuthNavigation : WwweDestinations("auth") {
        const val SIGN_IN = "signIn"
    }

    object MainNavigation : WwweDestinations("main") {
        const val HOME = "home"
    }
}

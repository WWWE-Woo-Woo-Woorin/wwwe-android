package app.junsu.wwwe

sealed class WwweDestinations(
    val route: String,
) {
    object AuthNavigation : WwweDestinations("auth") {
        const val SIGN_IN = "signIn"
    }

    object MainNavigation : WwweDestinations("main") {
        const val HOME = "home"
        const val CREATE_POST = "createPost"
    }
}

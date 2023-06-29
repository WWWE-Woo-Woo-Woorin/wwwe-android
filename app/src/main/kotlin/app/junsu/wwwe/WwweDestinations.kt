package app.junsu.wwwe

sealed class WwweDestinations(
    val route: String,
) {
    object MainNavigation : WwweDestinations("main") {
        const val HOME = "/home"
        const val COMPOSE_POST = "/createPost"

        object ChatNavigation : WwweDestinations("chat") {
            const val CHANNELS = "/channels"
            const val MESSAGES = "/messages"
        }
    }

    object AuthNavigation : WwweDestinations("auth") {
        const val SIGN_IN = "/signIn"
    }
}

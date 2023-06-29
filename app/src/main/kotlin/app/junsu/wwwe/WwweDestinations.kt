package app.junsu.wwwe

sealed class WwweDestinations(
    val route: String,
) {
    object MainNavigation : WwweDestinations("main") {
        const val HOME = "/home"
        const val COMPOSE_POST = "/createPost"
        const val CHAT_MESSAGES = "/chatMessages"
    }

    object AuthNavigation : WwweDestinations("auth") {
        const val SIGN_IN = "/signIn"
    }
}

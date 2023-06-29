package app.junsu.wwwe

sealed class WwweDestinations(val route: String) {
    object MainNavigation : WwweDestinations("main") {
        val HOME = this.route + "/home"
        val COMPOSE_POST = this.route + "/createPost"
        val CHAT_MESSAGES = this.route + "/chatMessages"
    }

    object AuthNavigation : WwweDestinations("auth") {
        val SIGN_IN = this.route + "/signIn"
    }
}

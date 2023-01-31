package app.junsu.remote.util

object URL {

    object Auth {

        // POST
        internal const val SIGN_IN = "/user"

        // POST
        internal const val REGENERATE_TOKEN = "/user/token"

        // GET
        object Check {
            internal const val EMAIL_SIGNED_UP = "/user/check/email"
            internal const val USERNAME_ENTERED = "/user/check/username"
        }

        // POST
        object SignUp {
            internal const val SIGN_UP_EMAIL = "/user/signup/email"
            internal const val ENTER_USERNAME = "/user/signup/username"
        }
    }
}

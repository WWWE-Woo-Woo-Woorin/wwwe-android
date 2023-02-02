package app.junsu.remote.util

object URL {

    object Auth {

        // POST
        internal const val SIGN_IN = "/user/signin"
        internal const val SIGN_UP = "/user/signup"

        // POST
        internal const val REGENERATE_TOKEN = "/user/token"

        // GET
        object Check {
            internal const val EMAIL_ENTERED = "/user/check/email"
            internal const val USERNAME_ENTERED = "/user/check/username"
        }

        // POST

        object SignUp {
            internal const val ENTER_EMAIL = "/user/signup/email"
            internal const val ENTER_USERNAME = "/user/signup/username"
            internal const val ENTER_PROFILE_URL = "/user/signup/profile"
        }
    }
}

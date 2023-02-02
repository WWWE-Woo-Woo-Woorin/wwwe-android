package app.junsu.remote.util

object URL {

    object Auth {

        internal const val SIGN_IN = "/user/signin"
        internal const val SIGN_UP = "/user/signup"

        internal const val REGENERATE_TOKEN = "/user/token"

        object Check {
            internal const val EMAIL_ENTERED = "/user/check/email"
            internal const val USERNAME_ENTERED = "/user/check/username"
        }

        object SignUp {
            internal const val ENTER_EMAIL = "/user/signup/email"
            internal const val ENTER_USERNAME = "/user/signup/username"
            internal const val ENTER_PROFILE_URL = "/user/signup/profile"
        }
    }
}

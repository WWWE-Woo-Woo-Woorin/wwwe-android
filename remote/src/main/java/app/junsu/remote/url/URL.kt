package app.junsu.remote.url

internal object URL {

    object Auth {

        internal const val SIGN_IN = "/v1/users/signin/{email}"
        internal const val SIGN_UP = "/v1/users/signup"
        internal const val FETCH_USER_INFORMATION = "/v1/users"

        internal const val REGENERATE_TOKEN = "/v1/users/token"

        object Check {
            internal const val EMAIL_SIGNED_IN = "/v1/users/check/email"
            internal const val USERNAME_ENTERED = "/v1/users/check/username"
        }

        object SignUp {
            internal const val SIGNUP_EMAIL = "/v1/users/signup/email"
            internal const val ENTER_USERNAME = "/v1/users/signup/username"
            internal const val ENTER_PROFILE_URL = "/v1/users/signup/profile"
        }
    }
}

package app.junsu.remote.url

internal object URL {

    object Auth {

        const val SIGN_IN = "/v1/users/signin/{email}"
        const val SIGN_UP = "/v1/users/signup"
        const val FETCH_USER_INFORMATION = "/v1/users"

        const val REGENERATE_TOKEN = "/v1/users/token"

        object Check {
            internal const val EMAIL_SIGNED_IN = "/v1/users/check/email"
            internal const val USERNAME_ENTERED = "/v1/users/check/username"
        }

        object SignUp {
            const val SIGNUP_EMAIL = "/v1/users/signup/email"
            const val ENTER_USERNAME = "/v1/users/signup/username"
            const val ENTER_PROFILE_URL = "/v1/users/signup/profile"
        }
    }

    object Post {
        const val CREATE_POST = "/v1/posts"
        const val INQUIRE_ALL_POSTS = "/v1/posts"
        const val INQUIRE_POSTS = "/v1/posts/{post-type}"
        const val INQUIRE_POST = "/v1/posts/{post-id}"
        const val UPDATE_POST = "/v1/posts/{post-id}"
        const val DELETE_POST = "/v1/posts/{post-id}"
    }
}

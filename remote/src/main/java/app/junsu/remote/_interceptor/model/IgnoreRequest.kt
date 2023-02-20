package app.junsu.remote._interceptor.model

import app.junsu.remote._common.URL

internal data class RequestInformation(
    val path: String,
    val method: HTTPMethod,
)

internal val ignoreRequests = listOf(
    RequestInformation(
        path = URL.Auth.Check.EMAIL_SIGNED_IN,
        method = HTTPMethod.GET,
    ),
    RequestInformation(
        path = URL.Auth.SIGN_IN,
        method = HTTPMethod.POST,
    ),
    RequestInformation(
        path = URL.Auth.REGENERATE_TOKEN,
        method = HTTPMethod.PUT,
    ),
    RequestInformation(
        path = URL.Auth.SIGN_UP,
        method = HTTPMethod.POST,
    ),
    RequestInformation(
        path = URL.Auth.SignUp.SIGNUP_EMAIL,
        method = HTTPMethod.POST,
    ),
)

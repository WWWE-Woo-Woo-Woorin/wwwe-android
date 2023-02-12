package app.junsu.remote.interceptor.model

import app.junsu.remote.util.URL

internal data class RequestInformation(
    val path: String,
    val method: HTTPMethod,
)

internal val ignoreRequests = listOf(
    RequestInformation(
        URL.Auth.SIGN_IN,
        HTTPMethod.POST,
    ),
    RequestInformation(
        URL.Auth.REGENERATE_TOKEN,
        HTTPMethod.PUT,
    ),
    RequestInformation(
        URL.Auth.SIGN_UP,
        HTTPMethod.POST,
    ),
    RequestInformation(
        URL.Auth.SignUp.SIGNUP_EMAIL,
        HTTPMethod.POST,
    ),
)

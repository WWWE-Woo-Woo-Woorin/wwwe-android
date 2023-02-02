package app.junsu.remote.interceptor.model

import app.junsu.remote.interceptor.model.HttpMethod.POST
import app.junsu.remote.interceptor.model.HttpMethod.PUT
import app.junsu.remote.util.URL

internal data class IgnoreRequest(
    val method: HttpMethod,
    val path: String,
)

internal val ignoreRequests = listOf(
    IgnoreRequest(POST, URL.Auth.SIGN_IN),
    IgnoreRequest(POST, URL.Auth.SIGN_UP),
    IgnoreRequest(PUT, URL.Auth.REGENERATE_TOKEN),
)

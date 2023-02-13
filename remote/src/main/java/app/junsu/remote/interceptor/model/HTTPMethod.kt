package app.junsu.remote.interceptor.model

internal enum class HTTPMethod {
    POST, GET, PUT, DELETE, PATCH, UNKNOWN,
    ;
}

internal fun String.toHttpMethod(): HTTPMethod {
    return when (this) {
        "POST" -> HTTPMethod.POST
        "GET" -> HTTPMethod.GET
        "PUT" -> HTTPMethod.PUT
        "DELETE" -> HTTPMethod.DELETE
        "PATCH" -> HTTPMethod.PATCH
        else -> HTTPMethod.UNKNOWN
    }
}

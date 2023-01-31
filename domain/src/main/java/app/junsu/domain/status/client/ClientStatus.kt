package app.junsu.domain.status.client

import app.junsu.domain.status.base.BaseStatus

sealed class ClientStatus(
    message: String? = null,
) : Throwable(
    message = message,
), BaseStatus {

    object BadRequest : ClientStatus("Bad Request") {
        override val statusCode: Int
            get() = 400
    }

    object Unauthorized : ClientStatus("Unauthorized") {
        override val statusCode: Int
            get() = 401
    }

    object Forbidden : ClientStatus("Forbidden") {
        override val statusCode: Int
            get() = 403
    }

    object NotFound : ClientStatus("Not Found") {
        override val statusCode: Int
            get() = 404
    }

    object MethodNotAllowed : ClientStatus("Method Not Allowed") {
        override val statusCode: Int
            get() = 405
    }

    object Conflict : ClientStatus("Conflicted") {
        override val statusCode: Int
            get() = 409
    }

    object TooManyRequests : ClientStatus("Too Many Requests") {
        override val statusCode: Int
            get() = 429
    }
}

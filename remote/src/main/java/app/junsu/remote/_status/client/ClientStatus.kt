package app.junsu.remote._status.client

import app.junsu.remote._status.base.BaseStatus

sealed class ClientStatus(
    message: String? = null,
) : Throwable(
    message = message,
), BaseStatus {

    class NoInternet : ClientStatus("No Internet") {
        override val statusCode: Int
            get() = -1
    }

    class BadRequest : ClientStatus("Bad Request") {
        override val statusCode: Int
            get() = 400
    }

    class Unauthorized : ClientStatus("Unauthorized") {
        override val statusCode: Int
            get() = 401
    }

    class Forbidden : ClientStatus("Forbidden") {
        override val statusCode: Int
            get() = 403
    }

    class NotFound : ClientStatus("Not Found") {
        override val statusCode: Int
            get() = 404
    }

    class MethodNotAllowed : ClientStatus("Method Not Allowed") {
        override val statusCode: Int
            get() = 405
    }

    class Conflict : ClientStatus("Conflicted") {
        override val statusCode: Int
            get() = 409
    }

    class TooManyRequests : ClientStatus("Too Many Requests") {
        override val statusCode: Int
            get() = 429
    }

    class Unknown : ClientStatus("Unknown") {
        override val statusCode: Int
            get() = -1
    }
}

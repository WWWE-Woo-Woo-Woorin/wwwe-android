package app.junsu.remote._status.server

import app.junsu.remote._status.base.BaseStatus

sealed class ServerStatus(
    message: String? = null,
) : Throwable(message = message), BaseStatus {

    class BadGateway : ServerStatus("Bad Gateway") {
        override val statusCode: Int
            get() = 502
    }

    class ServiceUnavailable : ServerStatus("Service Unavailable") {
        override val statusCode: Int
            get() = 504
    }

    class GatewayTimeout : ServerStatus("Gateway Timeout") {
        override val statusCode: Int
            get() = 504
    }
}

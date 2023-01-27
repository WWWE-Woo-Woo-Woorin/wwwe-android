package app.junsu.domain.status.server

import app.junsu.domain.status.base.BaseStatus

sealed class ServerStatus(
    message: String? = null,
) : Throwable(message = message), BaseStatus {

    object BadGateway : ServerStatus("Bad Gateway") {
        override val statusCode: Int
            get() = 502
    }

    object ServiceUnavailable : ServerStatus("Service Unavailable") {
        override val statusCode: Int
            get() = 504
    }

    object GatewayTimeout : ServerStatus("Gateway Timeout") {
        override val statusCode: Int
            get() = 504
    }
}

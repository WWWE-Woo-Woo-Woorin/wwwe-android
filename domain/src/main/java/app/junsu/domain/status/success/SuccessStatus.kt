package app.junsu.domain.status.success

import app.junsu.domain.status.base.BaseStatus

sealed class SuccessStatus : BaseStatus {

    object OK : SuccessStatus() {
        override val statusCode: Int
            get() = 200
    }

    object Created : SuccessStatus() {
        override val statusCode: Int
            get() = 201
    }

    object Accepted : SuccessStatus() {
        override val statusCode: Int
            get() = 202
    }

    object NoContent : SuccessStatus() {
        override val statusCode: Int
            get() = 204
    }
}

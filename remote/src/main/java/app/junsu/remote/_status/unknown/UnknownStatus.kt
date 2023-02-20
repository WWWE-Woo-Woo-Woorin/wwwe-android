package app.junsu.remote._status.unknown

sealed class UnknownStatus {
    class UnknownStatusException : UnknownStatus()
}

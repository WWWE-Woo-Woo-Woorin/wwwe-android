package app.junsu.domain.status.unknown

sealed class UnknownStatus {
    class UnknownStatusException : UnknownStatus()
}

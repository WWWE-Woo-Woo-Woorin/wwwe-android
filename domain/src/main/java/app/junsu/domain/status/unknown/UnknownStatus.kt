package app.junsu.domain.status.unknown

sealed class UnknownStatus {
    object UnknownStatusException : UnknownStatus()
}

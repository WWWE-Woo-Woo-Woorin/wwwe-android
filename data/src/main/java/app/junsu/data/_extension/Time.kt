package app.junsu.data._extension

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun LocalDateTime.toEpochSecond(): Long {
    return this.atZone(ZoneId.systemDefault()).toEpochSecond()
}

fun Long.epochSecondToLocalDateTime(): LocalDateTime {
    return Instant.ofEpochSecond(
        this,
    ).atZone(
        ZoneId.systemDefault(),
    ).toLocalDateTime()
}

package app.junsu.model.common

import java.time.LocalDateTime

data class Token(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresAt: LocalDateTime,
)

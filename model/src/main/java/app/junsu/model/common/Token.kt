package app.junsu.model.common

data class Token(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresAt: String,
)

package app.junsu.remote.auth.model

import app.junsu.model.common.Token
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class TokenResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("refresh_token_exp") val accessTokenExpiresAt: LocalDateTime,
) {
    internal fun toToken(): Token {
        return Token(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessTokenExpiresAt = accessTokenExpiresAt,
        )
    }
}

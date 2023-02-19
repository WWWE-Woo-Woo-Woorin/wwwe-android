package app.junsu.remote.auth.model

import app.junsu.model.common.Token
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class RegenerateTokenResponse(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("refreshToken") val refreshToken: String,
    @SerializedName("accessTokenExpiresAt") val accessTokenExpiresAt: LocalDateTime,
) {
    internal fun toToken(): Token {
        return Token(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessTokenExpiresAt = accessTokenExpiresAt,
        )
    }
}

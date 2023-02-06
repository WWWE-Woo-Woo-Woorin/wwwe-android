package app.junsu.remote.model.auth.signin

import app.junsu.model.Token
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class SignInResponse(
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

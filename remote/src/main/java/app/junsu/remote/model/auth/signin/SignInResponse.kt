package app.junsu.remote.model.auth.signin

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class SignInResponse(
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token_exp") val refreshTokenExpiresAt: LocalDateTime,
)

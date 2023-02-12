package app.junsu.remote.model.auth.token

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

internal data class RegenerateTokenResponse(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("refreshToken") val refreshToken: String,
    @SerializedName("accessTokenExpiresAt") val accessTokenExpiresAt: LocalDateTime,
)

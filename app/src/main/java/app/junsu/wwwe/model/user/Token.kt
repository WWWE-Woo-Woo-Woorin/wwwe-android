package app.junsu.wwwe.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
    @SerialName("access_token") val accessToken: String,
    @SerialName("access_token_exp") val accessTokenExp: String,
    @SerialName("refresh_token") val refreshToken: String,
)

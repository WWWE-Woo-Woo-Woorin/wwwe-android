package app.junsu.model.preference

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresAt: String,
) {
    companion object {
        fun getDefaultInstance(): UserPreferences {
            return UserPreferences(
                accessToken = "",
                refreshToken = "",
                accessTokenExpiresAt = "",
            )
        }
    }
}

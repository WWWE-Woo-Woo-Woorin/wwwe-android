package app.junsu.model.preference

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val email: String,
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresAt: String,
) {
    companion object {
        fun getDefaultInstance(): UserPreferences {
            return UserPreferences(
                email = "",
                accessToken = "",
                refreshToken = "",
                accessTokenExpiresAt = "",
            )
        }
    }
}

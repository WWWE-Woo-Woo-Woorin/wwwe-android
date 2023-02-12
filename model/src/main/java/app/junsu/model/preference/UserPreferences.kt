package app.junsu.model.preference

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val accessToken: String,
    val refreshToken: String,
) {
    companion object {
        fun getDefaultInstance(): UserPreferences {
            return UserPreferences(
                accessToken = "",
                refreshToken = "",
            )
        }
    }
}

package app.junsu.remote.model.auth.fetchuseriinformation

import app.junsu.model.common.User
import com.google.gson.annotations.SerializedName

data class FetchUserInformationResponse(
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String,
    @SerializedName("profileUrl") val profileUrl: String? = null,
) {
    internal fun toUser(): User {
        return User(
            email = email,
            username = username,
            profileUrl = profileUrl,
        )
    }
}

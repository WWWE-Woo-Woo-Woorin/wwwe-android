package app.junsu.remote.model.auth.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String,
    @SerializedName("profileUrl") val profileUrl: String? = null,
)

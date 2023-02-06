package app.junsu.remote.model.auth.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email") internal val email: String,
    @SerializedName("username") internal val username: String,
    @SerializedName("profileUrl") internal val profileUrl: String? = null,
)

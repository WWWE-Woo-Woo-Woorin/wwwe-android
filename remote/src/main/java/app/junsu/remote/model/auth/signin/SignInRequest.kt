package app.junsu.remote.model.auth.signin

import com.google.gson.annotations.SerializedName

internal data class SignInRequest(
    @SerializedName("email") val email: String,
    @SerializedName("deviceToken") val deviceToken: String? = "",
)

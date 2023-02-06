package app.junsu.remote.model.auth.signin

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email") internal val email: String,
    @SerializedName("deviceToken") internal val deviceToken: String? = "",
)

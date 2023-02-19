package app.junsu.remote.auth.model.signin

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email") val email: String,
)

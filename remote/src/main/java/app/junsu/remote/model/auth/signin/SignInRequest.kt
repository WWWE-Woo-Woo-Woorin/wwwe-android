package app.junsu.remote.model.auth.signin

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email") val email: String,
)

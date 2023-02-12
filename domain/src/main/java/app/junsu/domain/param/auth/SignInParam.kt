package app.junsu.domain.param.auth

data class SignInParam(
    internal val email: String,
    internal val accessToken: String? = "whhhat",
)

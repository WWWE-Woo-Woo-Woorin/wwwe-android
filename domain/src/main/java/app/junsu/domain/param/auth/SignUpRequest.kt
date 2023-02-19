package app.junsu.domain.param.auth

data class SignUpRequest(
    val email: String,
    val username: String,
    val profileUrl: String? = null,
)

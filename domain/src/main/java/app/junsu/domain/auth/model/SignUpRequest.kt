package app.junsu.domain.auth.model

data class SignUpRequest(
    val email: String,
    val username: String,
    val profileUrl: String? = null,
)

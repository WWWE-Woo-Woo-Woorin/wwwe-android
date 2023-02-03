package app.junsu.domain.param.auth

data class SignUpParam(
    val email: String,
    val username: String,
    val profileUrl: String? = null,
)

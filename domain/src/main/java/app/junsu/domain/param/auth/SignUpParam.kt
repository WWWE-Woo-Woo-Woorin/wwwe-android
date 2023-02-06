package app.junsu.domain.param.auth

data class SignUpParam(
    internal val email: String,
    internal val username: String,
    internal val profileUrl: String? = null,
)

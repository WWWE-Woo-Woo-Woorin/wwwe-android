package app.junsu.domain.param.auth

data class SignUpParam(
    private val email: String,
    private val username: String,
    private val profileUrl: String? = null,
)

package app.junsu.domain.usecase.auth

import app.junsu.domain.param.auth.SignInParam
import app.junsu.domain.repository.auth.AuthRepository

class SignInUseCase(
    private val repository: AuthRepository,
) {
    suspend operator fun invoke(
        param: SignInParam,
    ): Result<Unit> {
        return kotlin.runCatching {
            repository.signIn(
                email = param.email,
            )
        }
    }
}

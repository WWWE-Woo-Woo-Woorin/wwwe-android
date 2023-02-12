package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.param.auth.SignInParam
import app.junsu.domain.repository.auth.AuthRepository

class SignInUseCase(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        param: SignInParam,
    ): Result<Unit> {
        return kotlin.runCatching {
            authRepository.signIn(
                email = param.email,
                accessToken = param.accessToken!!,
            )
        }
    }
}

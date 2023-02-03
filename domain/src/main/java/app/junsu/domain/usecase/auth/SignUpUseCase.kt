package app.junsu.domain.usecase.auth

import app.junsu.domain.param.auth.SignUpParam
import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        param: SignUpParam,
    ): Result<Unit> {
        return kotlin.runCatching {
            authRepository.signUp(
                email = param.email,
                username = param.username,
                profileUrl = param.profileUrl,
            )
        }
    }
}

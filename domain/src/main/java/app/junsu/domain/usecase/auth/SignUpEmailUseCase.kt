package app.junsu.domain.usecase.auth

import app.junsu.domain.param.auth.SignUpEmailParam
import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignUpEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        param: SignUpEmailParam,
    ) {
        authRepository.signUpEmail(
            email = param.email,
        )
    }
}

package app.junsu.domain.usecase.auth

import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignUpEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ): Result<Unit> {
        return kotlin.runCatching {
            authRepository.signUpEmail(
                email = email,
            )
        }
    }
}

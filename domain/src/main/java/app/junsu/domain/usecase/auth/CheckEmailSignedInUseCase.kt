package app.junsu.domain.usecase.auth

import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class CheckEmailSignedInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ): Boolean {
        return authRepository.checkEmailSignedIn(
            email = email,
        )
    }
}

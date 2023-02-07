package app.junsu.domain.usecase.auth

import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke() {
        return authRepository.signInWithGoogle()
    }
}

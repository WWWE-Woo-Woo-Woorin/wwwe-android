package app.junsu.domain.usecase.auth.local

import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SaveEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ) {
        authRepository.saveEmail(
            email = email,
        )
    }
}

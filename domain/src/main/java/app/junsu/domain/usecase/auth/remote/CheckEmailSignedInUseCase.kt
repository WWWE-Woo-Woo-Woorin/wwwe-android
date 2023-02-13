package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class CheckEmailSignedInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ): Result<Boolean> {
        return kotlin.runCatching {
            authRepository.checkEmailSignedIn(
                email = email,
            )
        }
    }
}

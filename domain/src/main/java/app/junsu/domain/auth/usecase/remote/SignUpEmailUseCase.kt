package app.junsu.domain.auth.usecase.remote

import app.junsu.domain.auth.repository.remote.RemoteAuthRepository
import javax.inject.Inject

class SignUpEmailUseCase @Inject constructor(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ): Result<Unit> {
        return kotlin.runCatching {
            remoteAuthRepository.signUpEmail(
                email = email,
            )
        }
    }
}

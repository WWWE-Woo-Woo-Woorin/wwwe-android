package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.repository.auth.remote.RemoteAuthRepository
import javax.inject.Inject

class CheckEmailSignedInUseCase @Inject constructor(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ): Result<Boolean> {
        return kotlin.runCatching {
            remoteAuthRepository.checkEmailSignedIn(
                email = email,
            )
        }
    }
}

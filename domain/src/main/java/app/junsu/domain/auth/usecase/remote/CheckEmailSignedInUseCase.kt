package app.junsu.domain.auth.usecase.remote

import app.junsu.domain.auth.repository.remote.RemoteAuthRepository
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

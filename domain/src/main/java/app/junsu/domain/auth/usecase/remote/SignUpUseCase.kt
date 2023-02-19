package app.junsu.domain.auth.usecase.remote

import app.junsu.domain.auth.model.SignUpRequest
import app.junsu.domain.auth.repository.remote.RemoteAuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(
        request: SignUpRequest,
    ): Result<Unit> {
        return kotlin.runCatching {
            remoteAuthRepository.signUp(
                request = request,
            )
        }
    }
}

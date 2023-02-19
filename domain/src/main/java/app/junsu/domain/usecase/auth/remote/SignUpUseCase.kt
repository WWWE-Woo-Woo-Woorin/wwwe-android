package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.param.auth.SignUpRequest
import app.junsu.domain.repository.auth.remote.RemoteAuthRepository
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

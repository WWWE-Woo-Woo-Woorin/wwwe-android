package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.param.auth.SignUpParam
import app.junsu.domain.repository.auth.remote.RemoteAuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(
        param: SignUpParam,
    ): Result<Unit> {
        return kotlin.runCatching {
            remoteAuthRepository.signUp(
                email = param.email,
                username = param.username,
                profileUrl = param.profileUrl,
            )
        }
    }
}

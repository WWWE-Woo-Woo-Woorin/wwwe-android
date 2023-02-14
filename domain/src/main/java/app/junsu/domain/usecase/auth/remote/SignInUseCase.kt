package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.param.auth.SignInParam
import app.junsu.domain.repository.auth.remote.RemoteAuthRepository

class SignInUseCase(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(
        param: SignInParam,
    ): Result<Unit> {
        return kotlin.runCatching {
            remoteAuthRepository.signIn(
                email = param.email,
                accessToken = param.accessToken!!,
            )
        }
    }
}

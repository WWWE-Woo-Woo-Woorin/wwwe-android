package app.junsu.domain.auth.usecase.remote

import app.junsu.domain.auth.repository.remote.RemoteAuthRepository

class SignInUseCase(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ): Result<Unit> {
        return kotlin.runCatching {
            remoteAuthRepository.signIn(
                email = email,
            )
        }
    }
}

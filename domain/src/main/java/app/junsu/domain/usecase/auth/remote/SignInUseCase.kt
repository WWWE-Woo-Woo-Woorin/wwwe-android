package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.repository.auth.remote.RemoteAuthRepository

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

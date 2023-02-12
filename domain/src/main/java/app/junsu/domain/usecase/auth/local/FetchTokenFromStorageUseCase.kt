package app.junsu.domain.usecase.auth.local

import app.junsu.domain.repository.auth.AuthRepository
import app.junsu.model.common.Token
import javax.inject.Inject

class FetchTokenFromStorageUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    private suspend operator fun invoke(): Token {
        return authRepository.fetchTokenFromStorage()
    }
}
